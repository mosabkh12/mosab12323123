package game.competition;

import game.arena.IArena;
import model.CompetitorImpl;
import utilities.ValidationUtils;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class Competition implements Observer {
    private IArena arena;
    private final ArrayList<CompetitorImpl> activeCompetitors;
    private final ArrayList<CompetitorImpl> finishedCompetitors;
    private final int maxCompetitors;

    public Competition(IArena arena, int maxCompetitors) {
        this.maxCompetitors = maxCompetitors;
        this.activeCompetitors = new ArrayList<>();
        this.finishedCompetitors = new ArrayList<>();
        this.arena = arena;
    }

    protected abstract boolean isValidCompetitor(Competitor competitor);

    public void addCompetitor(Competitor competitor){
        ValidationUtils.assertNotNull(competitor);
        if(maxCompetitors <= activeCompetitors.size()){
            throw new IllegalStateException("WinterArena is full max = "+ maxCompetitors);
        }
        if(isValidCompetitor(competitor)){
            competitor.initRace();
            ((CompetitorImpl) competitor).addObserver(this);
            activeCompetitors.add((CompetitorImpl) competitor);
        }
        else{
            throw new IllegalArgumentException("Invalid competitor "+ competitor);
        }
    }

    public void startCompetition() {
        for (CompetitorImpl competitor : activeCompetitors) {
            new Thread(competitor).start();
        }
    }

    public boolean hasActiveCompetitors(){
        return activeCompetitors.size() > 0;
    }

    public ArrayList<CompetitorImpl> getFinishedCompetitors() {
        return new ArrayList<>(finishedCompetitors);
    }

    @Override
    public void update(Observable o, Object arg) {
        CompetitorImpl competitor = (CompetitorImpl) o;
        if (competitor.isFinished()) {
            finishedCompetitors.add(competitor);
            activeCompetitors.remove(competitor);
            System.out.println(competitor.getName() + " has finished!");
        }
        // Update GUI or other components as needed
    }
}
