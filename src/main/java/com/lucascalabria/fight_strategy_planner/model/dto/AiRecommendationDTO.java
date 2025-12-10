package com.lucascalabria.fight_strategy_planner.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for adding an AI Recommendation to a Tactical Plan (User Story 1.4).
 */
@Getter
@Setter
public class AiRecommendationDTO {

    @NotBlank(message = "AI recommendation cannot be blank")
    private String aiRecommendation;
}