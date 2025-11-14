package com.lucascalabria.fight_strategy_planner.service;

import com.lucascalabria.fight_strategy_planner.model.dto.FighterGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FighterPostDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FighterUpdateDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Coach;
import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.repository.CoachRepository;
import com.lucascalabria.fight_strategy_planner.repository.FighterRepository;
import com.lucascalabria.fight_strategy_planner.util.FighterConversor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FighterService {
    private final FighterRepository fighterRepository;
    private FighterConversor conversor;
    private CoachRepository coachRepository;

    public List<FighterGetDTO> listAllFighters() {
        List<Fighter> fighters = fighterRepository.findAll();
        List<FighterGetDTO> fighterDTOs = new ArrayList<>();
        for (Fighter fighter : fighters) {
            FighterGetDTO fighterDTO = conversor.toDTO(fighter);
            fighterDTOs.add(fighterDTO);
        }
        return fighterDTOs;
    }

    public Fighter createFighter(FighterPostDTO fighterDTO) {

        if (fighterDTO.getName() == null || fighterDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Fighter name is required.");
        }

        if (fighterDTO.getAge() <= 0) {
            throw new IllegalArgumentException("Fighter age must be greater than zero.");
        }

        if (fighterDTO.getWeightCategory() == null) {
            throw new IllegalArgumentException("Weight category is required.");
        }

        if (fighterDTO.getFightingStyle() == null) {
            throw new IllegalArgumentException("Fighting style is required.");
        }


        if (fighterRepository.existsByName(fighterDTO.getName())) {
            throw new IllegalArgumentException("A fighter with this name already exists.");
        }
        Coach coach = coachRepository.findById(fighterDTO.getCoachId())
                .orElseThrow(() -> new IllegalArgumentException("Coach not found."));
        Fighter fighter = conversor.toEntity(fighterDTO, coach);

        return fighterRepository.save(fighter);
    }

    public Fighter updateFighter(Long id, FighterUpdateDTO fighterUpdateDTO) {
        Fighter fighter = fighterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fighter not found"));
        if (fighterUpdateDTO.getName() != null) fighter.setName(fighterUpdateDTO.getName());
        if (fighterUpdateDTO.getAge() != null) fighter.setAge(fighterUpdateDTO.getAge());
        if (fighterUpdateDTO.getWeightCategory() != null) fighter.setWeightCategory(fighterUpdateDTO.getWeightCategory());
        if (fighterUpdateDTO.getFightingStyle() != null) fighter.setFightingStyle(fighterUpdateDTO.getFightingStyle());
        if (fighterUpdateDTO.getRecordSummary() != null) fighter.setRecordSummary(fighterUpdateDTO.getRecordSummary());
        if (fighterUpdateDTO.getCoachId() != null) {
            Coach coach = coachRepository.findById(fighterUpdateDTO.getCoachId())
                    .orElseThrow(() -> new RuntimeException("Coach not found"));
            fighter.setCoach(coach);
        }

        return fighterRepository.save(fighter);
    }

    public void deleteFighter(Long id) {
        if (!fighterRepository.existsById(id)) {
            throw new RuntimeException("Fighter not found");
        }
        fighterRepository.deleteById(id);
    }

}
