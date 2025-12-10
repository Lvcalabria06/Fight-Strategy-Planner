package com.lucascalabria.fight_strategy_planner.util;
import com.lucascalabria.fight_strategy_planner.model.dto.FeedbackGetDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackConversor {
    public FeedbackGetDTO toDTO(Feedback f) {
        return FeedbackGetDTO.builder()
                .id(f.getId())
                .fighterId(f.getFighter().getId())
                .fighterName(f.getFighter().getName())
                .tacticalPlanId(
                        f.getTacticalPlan() != null ? f.getTacticalPlan().getId() : null
                )
                .message(f.getMessage())
                .createdAt(f.getCreatedAt())
                .build();
    }
}
