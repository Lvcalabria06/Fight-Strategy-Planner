package com.lucascalabria.fight_strategy_planner.model.dto;

import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.model.entity.TacticalPlan;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for "output" (responses) related to Tactical Plans.
 * It provides a safe representation of the plan and its associated fighter.
 */
@Getter
@Setter
public class TacticalPlanGetDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private TacticalPlan.Status status;
    private String aiRecommendation;
    private LocalDateTime createdAt;
    private FighterInfoDTO fighter;

    /**
     * Nested static DTO to safely represent basic fighter info.
     */
    @Getter
    @Setter
    public static class FighterInfoDTO {
        private Long id;
        private String name;

        public FighterInfoDTO(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * Constructor to map the Entity to this DTO.
     * @param tacticalPlan The entity from the database.
     */
    public TacticalPlanGetDTO(TacticalPlan tacticalPlan) {
        this.id = tacticalPlan.getId();
        this.title = tacticalPlan.getTitle();
        this.description = tacticalPlan.getDescription();
        this.startDate = tacticalPlan.getStartDate();
        this.endDate = tacticalPlan.getEndDate();
        this.status = tacticalPlan.getStatus();
        this.aiRecommendation = tacticalPlan.getAiRecommendation();
        this.createdAt = tacticalPlan.getCreatedAt();

        if (tacticalPlan.getFighter() != null) {
            Fighter fighter = tacticalPlan.getFighter();
            this.fighter = new FighterInfoDTO(fighter.getId(), fighter.getName());
        }
    }
}