package com.lucascalabria.fight_strategy_planner.service;

import com.lucascalabria.fight_strategy_planner.model.dto.EvaluationGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.EvaluationPostDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Evaluation;
import com.lucascalabria.fight_strategy_planner.model.entity.TacticalPlan;
import com.lucascalabria.fight_strategy_planner.repository.EvaluationRepository;
import com.lucascalabria.fight_strategy_planner.repository.TacticalPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final TacticalPlanRepository tacticalPlanRepository;

    public EvaluationGetDTO create(EvaluationPostDTO dto) {

        TacticalPlan plan = tacticalPlanRepository.findById(dto.tacticalPlanId())
                .orElseThrow(() -> new RuntimeException("TacticalPlan not found"));

        BigDecimal avg = BigDecimal.valueOf(
                (dto.technique() + dto.endurance() + dto.focus()) / 3.0
        ).setScale(2, RoundingMode.HALF_UP);

        Evaluation evaluation = Evaluation.builder()
                .tacticalPlan(plan)
                .technique(dto.technique())
                .endurance(dto.endurance())
                .focus(dto.focus())
                .averageScore(avg)
                .build();

        Evaluation saved = evaluationRepository.save(evaluation);
        return toDTO(saved);
    }

    public List<EvaluationGetDTO> findAll() {
        return evaluationRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public EvaluationGetDTO findById(Long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
        return toDTO(evaluation);
    }

    public EvaluationGetDTO update(Long id, EvaluationPostDTO dto) {

        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));

        TacticalPlan plan = tacticalPlanRepository.findById(dto.tacticalPlanId())
                .orElseThrow(() -> new RuntimeException("TacticalPlan not found"));

        BigDecimal avg = BigDecimal.valueOf(
                (dto.technique() + dto.endurance() + dto.focus()) / 3.0
        ).setScale(2, RoundingMode.HALF_UP);

        evaluation.setTacticalPlan(plan);
        evaluation.setTechnique(dto.technique());
        evaluation.setEndurance(dto.endurance());
        evaluation.setFocus(dto.focus());
        evaluation.setAverageScore(avg);

        Evaluation saved = evaluationRepository.save(evaluation);
        return toDTO(saved);
    }

    public void delete(Long id) {
        if (!evaluationRepository.existsById(id)) {
            throw new RuntimeException("Evaluation not found");
        }
        evaluationRepository.deleteById(id);
    }

    private EvaluationGetDTO toDTO(Evaluation e) {
        return new EvaluationGetDTO(
                e.getId(),
                e.getTacticalPlan().getId(),
                e.getTechnique(),
                e.getEndurance(),
                e.getFocus(),
                e.getAverageScore(),
                e.getEvaluationDate()
        );
    }
}
