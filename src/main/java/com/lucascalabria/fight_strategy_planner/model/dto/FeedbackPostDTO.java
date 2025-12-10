package com.lucascalabria.fight_strategy_planner.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackPostDTO {

    private Long fighterId;
    private Long tacticalPlanId;
    private String message;
}
