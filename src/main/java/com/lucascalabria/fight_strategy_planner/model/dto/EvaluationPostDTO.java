package com.lucascalabria.fight_strategy_planner.model.dto;

public record EvaluationPostDTO(
        Long tacticalPlanId,
        int technique,
        int endurance,
        int focus
) {}
