package game.competition;

import game.arena.IArena;

public class SkiCompetition extends Competition {
    public SkiCompetition(IArena arena, int maxCompetitors) {
        super(arena, maxCompetitors);
    }

    @Override
    protected boolean isValidCompetitor(Competitor competitor) {
        return true; // Simplified validation logic
    }
}
