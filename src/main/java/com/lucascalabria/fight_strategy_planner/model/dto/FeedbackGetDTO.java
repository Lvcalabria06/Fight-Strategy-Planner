package com.lucascalabria.fight_strategy_planner.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class FeedbackGetDTO {

    private Long id;
    private Long fighterId;
    private String fighterName;
    private Long tacticalPlanId;
    private String message;
    private LocalDateTime createdAt;
}
