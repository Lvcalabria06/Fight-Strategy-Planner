package com.lucascalabria.fight_strategy_planner.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EvaluationGetDTO(
        Long id,
        Long tacticalPlanId,
        int technique,
        int endurance,
        int focus,
        BigDecimal averageScore,
        LocalDateTime evaluationDate
) {}
