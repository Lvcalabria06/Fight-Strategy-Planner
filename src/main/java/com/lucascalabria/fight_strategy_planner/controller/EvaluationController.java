package com.lucascalabria.fight_strategy_planner.controller;

import com.lucascalabria.fight_strategy_planner.model.dto.EvaluationGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.EvaluationPostDTO;
import com.lucascalabria.fight_strategy_planner.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService service;

    @PostMapping
    public EvaluationGetDTO create(@RequestBody EvaluationPostDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<EvaluationGetDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EvaluationGetDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public EvaluationGetDTO update(
            @PathVariable Long id,
            @RequestBody EvaluationPostDTO dto
    ) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
