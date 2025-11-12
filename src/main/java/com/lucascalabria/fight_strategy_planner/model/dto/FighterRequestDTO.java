package com.lucascalabria.fight_strategy_planner.model.dto;

import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.model.enums.FightingStyle;
import com.lucascalabria.fight_strategy_planner.model.enums.WeightCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FighterRequestDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    @NotNull(message = "Weight category cannot be null")
    private WeightCategory weightCategory;

    @NotNull(message = "Fighting style cannot be null")
    private FightingStyle fightingStyle;

    private String recordSummary;

    @NotNull(message = "Coach ID cannot be null")
    private Long coachId;

}