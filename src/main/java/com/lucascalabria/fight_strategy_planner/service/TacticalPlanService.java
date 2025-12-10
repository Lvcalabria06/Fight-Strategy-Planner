package com.lucascalabria.fight_strategy_planner.service;

import com.lucascalabria.fight_strategy_planner.model.dto.AiRecommendationDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.TacticalPlanPostDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.TacticalPlanGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.UpdatePlanStatusDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.model.entity.TacticalPlan;
import com.lucascalabria.fight_strategy_planner.repository.FighterRepository;
import com.lucascalabria.fight_strategy_planner.repository.TacticalPlanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TacticalPlanService {

    private final TacticalPlanRepository tacticalPlanRepository;
    private final FighterRepository fighterRepository;

    /**
     * User Story 1.1: Create a Tactical Plan for a Fighter
     */
    @Transactional
    public TacticalPlanGetDTO createTacticalPlan(TacticalPlanPostDTO dto) {
        // 1. Find the associated Fighter
        Fighter fighter = fighterRepository.findById(dto.getFighterId())
                .orElseThrow(() -> new EntityNotFoundException("Fighter not found with id: " + dto.getFighterId()));

        // 2. Map DTO to Entity
        TacticalPlan plan = new TacticalPlan();
        plan.setTitle(dto.getTitle());
        plan.setDescription(dto.getDescription());
        plan.setStartDate(dto.getStartDate());
        plan.setEndDate(dto.getEndDate());
        plan.setFighter(fighter);
        // Status defaults to PLANNED (as per entity definition)

        // 3. Save and return DTO
        TacticalPlan savedPlan = tacticalPlanRepository.save(plan);
        return new TacticalPlanGetDTO(savedPlan);
    }
        
    /**
     * User Story 1.3: List All Tactical Plans of a Fighter
     */
    @Transactional(readOnly = true)
    public List<TacticalPlanGetDTO> getTacticalPlansByFighterId(Long fighterId) {
        if (!fighterRepository.existsById(fighterId)) {
            throw new EntityNotFoundException("Fighter not found with id: " + fighterId);
        }

        List<TacticalPlan> plans = tacticalPlanRepository.findByFighterId(fighterId);
        return plans.stream()
                .map(TacticalPlanGetDTO::new)
                .collect(Collectors.toList());
    }

    /**
     * User Story 1.2: Update Tactical Plan Status
     */
    @Transactional
    public TacticalPlanGetDTO updateTacticalPlanStatus(Long planId, UpdatePlanStatusDTO dto) {
        TacticalPlan plan = tacticalPlanRepository.findById(planId)
                .orElseThrow(() -> new EntityNotFoundException("Tactical Plan not found with id: " + planId));

        plan.setStatus(dto.getStatus());
        TacticalPlan updatedPlan = tacticalPlanRepository.save(plan);
        return new TacticalPlanGetDTO(updatedPlan);
    }

    /**
     * User Story 1.4: Add AI Recommendation to Tactical Plan
     */
    @Transactional
    public TacticalPlanGetDTO addAiRecommendation(Long planId, AiRecommendationDTO dto) {
        TacticalPlan plan = tacticalPlanRepository.findById(planId)
                .orElseThrow(() -> new EntityNotFoundException("Tactical Plan not found with id: " + planId));

        plan.setAiRecommendation(dto.getAiRecommendation());
        TacticalPlan updatedPlan = tacticalPlanRepository.save(plan);
        return new TacticalPlanGetDTO(updatedPlan);
    }

    // Helper method to get a single plan (useful for other operations)
    @Transactional(readOnly = true)
    public TacticalPlanGetDTO getTacticalPlanById(Long planId) {
        TacticalPlan plan = tacticalPlanRepository.findById(planId)
                .orElseThrow(() -> new EntityNotFoundException("Tactical Plan not found with id: " + planId));
        return new TacticalPlanGetDTO(plan);
    }

    @Transactional
    public void deleteTacticalPlan(Long planId) {
        TacticalPlan plan = tacticalPlanRepository.findById(planId)
                .orElseThrow(() -> new EntityNotFoundException("Tactical Plan not found with id: " + planId));

        tacticalPlanRepository.delete(plan);
    }

}