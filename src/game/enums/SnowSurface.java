package game.enums;

public enum SnowSurface {
    POWDER(0.2),
    PACKED(0.1),
    ICY(0.3);

    private final double friction;

    SnowSurface(double friction) {
        this.friction = friction;
    }

    public double getFriction() {
        return friction;
    }
}
