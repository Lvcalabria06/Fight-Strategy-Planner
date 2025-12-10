package com.lucascalabria.fight_strategy_planner.controller;

import com.lucascalabria.fight_strategy_planner.model.dto.*;
import com.lucascalabria.fight_strategy_planner.service.TacticalPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tactical-plans")
@RequiredArgsConstructor
public class TacticalPlanController {

    private final TacticalPlanService tacticalPlanService;

    /**
     * User Story 1.1 — Create a Tactical Plan for a Fighter
     */
    @PostMapping
    public ResponseEntity<TacticalPlanGetDTO> createTacticalPlan(
            @Valid @RequestBody TacticalPlanPostDTO dto) {
        return ResponseEntity.ok(tacticalPlanService.createTacticalPlan(dto));
    }

    /**
     * User Story 1.3 — List all Tactical Plans of a Fighter
     */
    @GetMapping("/fighter/{fighterId}")
    public ResponseEntity<List<TacticalPlanGetDTO>> getPlansByFighter(
            @PathVariable Long fighterId) {
        return ResponseEntity.ok(tacticalPlanService.getTacticalPlansByFighterId(fighterId));
    }

    /**
     * Get a single Tactical Plan by ID
     */
    @GetMapping("/{planId}")
    public ResponseEntity<TacticalPlanGetDTO> getTacticalPlan(@PathVariable Long planId) {
        return ResponseEntity.ok(tacticalPlanService.getTacticalPlanById(planId));
    }

    /**
     * User Story 1.2 — Update Tactical Plan Status
     */
    @PatchMapping("/{planId}/status")
    public ResponseEntity<TacticalPlanGetDTO> updatePlanStatus(
            @PathVariable Long planId,
            @Valid @RequestBody UpdatePlanStatusDTO dto) {
        return ResponseEntity.ok(tacticalPlanService.updateTacticalPlanStatus(planId, dto));
    }

    /**
     * User Story 1.4 — Add AI Recommendation
     */
    @PatchMapping("/{planId}/ai-recommendation")
    public ResponseEntity<TacticalPlanGetDTO> addAiRecommendation(
            @PathVariable Long planId,
            @Valid @RequestBody AiRecommendationDTO dto) {
        return ResponseEntity.ok(tacticalPlanService.addAiRecommendation(planId, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTacticalPlan(@PathVariable Long id) {
        tacticalPlanService.deleteTacticalPlan(id);
        return ResponseEntity.noContent().build();
    }

}
