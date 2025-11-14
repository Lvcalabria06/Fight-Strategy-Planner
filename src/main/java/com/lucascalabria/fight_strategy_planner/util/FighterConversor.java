package com.lucascalabria.fight_strategy_planner.util;

import com.lucascalabria.fight_strategy_planner.model.dto.FighterGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FighterPostDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Coach;
import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import org.springframework.stereotype.Component;

@Component
public class FighterConversor {
    public FighterGetDTO toDTO(Fighter fighter) {
        if (fighter == null) {
            return null;
        }

        return FighterGetDTO.builder()
                .name(fighter.getName())
                .age(fighter.getAge())
                .weightCategory(fighter.getWeightCategory())
                .fightingStyle(fighter.getFightingStyle())
                .recordSummary(fighter.getRecordSummary())
                .build();
    }
    public Fighter toEntity(FighterPostDTO dto, Coach coach) {
        return Fighter.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .weightCategory(dto.getWeightCategory())
                .fightingStyle(dto.getFightingStyle())
                .recordSummary(dto.getRecordSummary())
                .coach(coach)
                .build();
    }

}
