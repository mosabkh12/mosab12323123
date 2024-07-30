package game.arena;

import model.CompetitorImpl;

public interface IArena {
    boolean isFinished(CompetitorImpl competitor);
    double getFriction();
}
