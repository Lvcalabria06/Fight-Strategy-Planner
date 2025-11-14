package com.lucascalabria.fight_strategy_planner.controller;

import com.lucascalabria.fight_strategy_planner.model.dto.FighterGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FighterPostDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FighterUpdateDTO;
import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import com.lucascalabria.fight_strategy_planner.service.FighterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fighters")
public class FighterController {
    private FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    // Get all Fighters from Coach
    @GetMapping
    public ResponseEntity<?> getFighters() {
        try {
            List<FighterGetDTO> fighters = fighterService.listAllFighters();
            return ResponseEntity.ok(fighters);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> createFighter(@RequestBody FighterPostDTO newFighter) {
        try {
            return new ResponseEntity<>(fighterService.createFighter(newFighter), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFighter(@PathVariable Long id, @RequestBody FighterUpdateDTO updatedFighter) {
        try {
            return ResponseEntity.ok(fighterService.updateFighter(id, updatedFighter));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFighter(@PathVariable Long id) {
        try {
            fighterService.deleteFighter(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
