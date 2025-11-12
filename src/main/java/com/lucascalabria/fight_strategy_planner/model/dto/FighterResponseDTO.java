package com.lucascalabria.fight_strategy_planner.model.dto;

import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.model.enums.FightingStyle;
import com.lucascalabria.fight_strategy_planner.model.enums.WeightCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class FighterResponseDTO {

    private Long id;
    private String name;
    private int age;
    private WeightCategory weightCategory;
    private FightingStyle fightingStyle;
    private String recordSummary;
    private LocalDateTime createdAt;
    private CoachInfoDTO coach;

    public FighterResponseDTO(Fighter fighter) {
        this.id = fighter.getId();
        this.name = fighter.getName();
        this.age = fighter.getAge();
        this.weightCategory = fighter.getWeightCategory();
        this.fightingStyle = fighter.getFightingStyle();
        this.recordSummary = fighter.getRecordSummary();
        this.createdAt = fighter.getCreatedAt();

        // Mapeamento seguro do Coach
        if (fighter.getCoach() != null) {
            this.coach = new CoachInfoDTO(
                    fighter.getCoach().getId(),
                    fighter.getCoach().getName(),
                    fighter.getCoach().getGymName()
            );
        }
    }
}