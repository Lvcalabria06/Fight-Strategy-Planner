package com.lucascalabria.fight_strategy_planner.model.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO for creating a new Tactical Plan (User Story 1.1).
 * It expects all necessary data, including the ID of the fighter to assign the plan to.
 */
@Getter
@Setter
public class TacticalPlanPostDTO {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String description;

    @NotNull(message = "Start date cannot be null")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    @FutureOrPresent(message = "End date must be in the present or future")
    private LocalDate endDate;

    @NotNull(message = "Fighter ID cannot be null")
    private Long fighterId;
}