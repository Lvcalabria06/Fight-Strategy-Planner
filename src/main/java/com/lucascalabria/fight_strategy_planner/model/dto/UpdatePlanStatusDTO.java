package com.lucascalabria.fight_strategy_planner.model.dto;

import com.lucascalabria.fight_strategy_planner.model.entity.TacticalPlan;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for updating a Tactical Plan's status (User Story 1.2).
 */
@Getter
@Setter
public class UpdatePlanStatusDTO {

    @NotNull(message = "Status cannot be null")
    private TacticalPlan.Status status;
}