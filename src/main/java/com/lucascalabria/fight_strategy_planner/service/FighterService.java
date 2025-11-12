package com.lucascalabria.fight_strategy_planner.service;

import com.lucascalabria.fight_strategy_planner.model.dto.FighterRequestDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FighterResponseDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Coach;
import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.repository.CoachRepository;
import com.lucascalabria.fight_strategy_planner.repository.FighterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FighterService {

    private final FighterRepository fighterRepository;
    private final CoachRepository coachRepository;

    @Transactional
    public FighterResponseDTO createFighter(FighterRequestDTO dto) {
        Coach coach = coachRepository.findById(dto.getCoachId())
                .orElseThrow(() -> new EntityNotFoundException("Coach not found with id: " + dto.getCoachId()));

        Fighter fighter = new Fighter();
        fighter.setName(dto.getName());
        fighter.setAge(dto.getAge());
        fighter.setWeightCategory(dto.getWeightCategory());
        fighter.setFightingStyle(dto.getFightingStyle());
        fighter.setRecordSummary(dto.getRecordSummary());
        fighter.setCoach(coach);

        fighterRepository.save(fighter);

        return new FighterResponseDTO(fighter);
    }

    @Transactional(readOnly = true)
    public FighterResponseDTO getFighterById(Long fighterId) {
        Fighter fighter = fighterRepository.findById(fighterId)
                .orElseThrow(() -> new EntityNotFoundException("Fighter not found with id: " + fighterId));
        return new FighterResponseDTO(fighter);
    }


    @Transactional(readOnly = true)
    public List<FighterResponseDTO> getFightersByCoachId(Long coachId) {
        List<Fighter> fighters = fighterRepository.findByCoachId(coachId);
        return fighters.stream()
                .map(FighterResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public FighterResponseDTO updateFighter(Long fighterId, FighterRequestDTO dto) {
        Fighter fighter = fighterRepository.findById(fighterId)
                .orElseThrow(() -> new EntityNotFoundException("Fighter not found with id: " + fighterId));


        if (!fighter.getCoach().getId().equals(dto.getCoachId())) {
            Coach newCoach = coachRepository.findById(dto.getCoachId())
                    .orElseThrow(() -> new EntityNotFoundException("New Coach not found with id: " + dto.getCoachId()));
            fighter.setCoach(newCoach);
        }

        fighter.setName(dto.getName());
        fighter.setAge(dto.getAge());
        fighter.setWeightCategory(dto.getWeightCategory());
        fighter.setFightingStyle(dto.getFightingStyle());
        fighter.setRecordSummary(dto.getRecordSummary());

        Fighter updatedFighter = fighterRepository.save(fighter);

        return new FighterResponseDTO(updatedFighter);
    }

    @Transactional
    public void deleteFighter(Long fighterId) {
        if (!fighterRepository.existsById(fighterId)) {
            throw new EntityNotFoundException("Fighter not found with id: " + fighterId);
        }
        fighterRepository.deleteById(fighterId);
    }
}