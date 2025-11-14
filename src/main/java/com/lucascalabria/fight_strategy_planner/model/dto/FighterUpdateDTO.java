package com.lucascalabria.fight_strategy_planner.model.dto;

import com.lucascalabria.fight_strategy_planner.model.enums.FightingStyle;
import com.lucascalabria.fight_strategy_planner.model.enums.WeightCategory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class FighterUpdateDTO {

    private String name;
    private Integer age;
    private WeightCategory weightCategory;
    private FightingStyle fightingStyle;
    private String recordSummary;
    private Long coachId;

}
