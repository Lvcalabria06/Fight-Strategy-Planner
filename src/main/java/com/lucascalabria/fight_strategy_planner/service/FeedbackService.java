package com.lucascalabria.fight_strategy_planner.service;

import com.lucascalabria.fight_strategy_planner.model.dto.FeedbackGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FeedbackPostDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Feedback;
import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.model.entity.TacticalPlan;
import com.lucascalabria.fight_strategy_planner.util.FeedbackConversor;
import com.lucascalabria.fight_strategy_planner.repository.FeedbackRepository;
import com.lucascalabria.fight_strategy_planner.repository.FighterRepository;
import com.lucascalabria.fight_strategy_planner.repository.TacticalPlanRepository;
import com.lucascalabria.fight_strategy_planner.util.FeedbackConversor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FighterRepository fighterRepository;
    private final TacticalPlanRepository tacticalPlanRepository;
    private final FeedbackConversor feedbackMapper;

    public FeedbackGetDTO createFeedback(FeedbackPostDTO dto) {

        Fighter fighter = fighterRepository.findById(dto.getFighterId())
                .orElseThrow(() -> new RuntimeException("Fighter not found"));

        TacticalPlan tacticalPlan = null;
        if (dto.getTacticalPlanId() != null) {
            tacticalPlan = tacticalPlanRepository.findById(dto.getTacticalPlanId())
                    .orElseThrow(() -> new RuntimeException("Tactical Plan not found"));
        }

        Feedback feedback = Feedback.builder()
                .fighter(fighter)
                .tacticalPlan(tacticalPlan)
                .message(dto.getMessage())
                .build();

        return feedbackMapper.toDTO(feedbackRepository.save(feedback));
    }

    public List<FeedbackGetDTO> getAll() {
        return feedbackRepository.findAll().stream()
                .map(feedbackMapper::toDTO)
                .toList();
    }

    public FeedbackGetDTO getById(Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        return feedbackMapper.toDTO(feedback);
    }

    public FeedbackGetDTO updateFeedback(Long id, FeedbackPostDTO dto) {
        Feedback f = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        if (dto.getMessage() != null) f.setMessage(dto.getMessage());
        if (dto.getFighterId() != null) {
            Fighter fighter = fighterRepository.findById(dto.getFighterId())
                    .orElseThrow(() -> new RuntimeException("Fighter not found"));
            f.setFighter(fighter);
        }
        if (dto.getTacticalPlanId() != null) {
            TacticalPlan tacticalPlan = tacticalPlanRepository.findById(dto.getTacticalPlanId())
                    .orElseThrow(() -> new RuntimeException("Tactical Plan not found"));
            f.setTacticalPlan(tacticalPlan);
        }

        return feedbackMapper.toDTO(feedbackRepository.save(f));
    }

    public void deleteFeedback(Long id) {
        if (!feedbackRepository.existsById(id))
            throw new RuntimeException("Feedback not found");

        feedbackRepository.deleteById(id);
    }
}
