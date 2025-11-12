package com.lucascalabria.fight_strategy_planner.model.enums;

public enum WeightCategory {
    FLYWEIGHT("Flyweight"),       // ~57kg
    BANTAMWEIGHT("Bantamweight"), //  ~61kg
    FEATHERWEIGHT("Featherweight"), //  ~66kg
    LIGHTWEIGHT("Lightweight"),   //  ~70kg
    WELTERWEIGHT("Welterweight"), // ~77kg
    MIDDLEWEIGHT("Middleweight"), // ~84kg
    LIGHT_HEAVYWEIGHT("Light Heavyweight"), //~93kg
    HEAVYWEIGHT("Heavyweight");   // +93kg

    private final String displayName;

    WeightCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
