package com.lucascalabria.fight_strategy_planner.model.dto;

import com.lucascalabria.fight_strategy_planner.model.enums.FightingStyle;
import com.lucascalabria.fight_strategy_planner.model.enums.WeightCategory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FighterGetDTO {

    private String name;
    private int age;
    private WeightCategory weightCategory;
    private FightingStyle fightingStyle;
    private String recordSummary;
}