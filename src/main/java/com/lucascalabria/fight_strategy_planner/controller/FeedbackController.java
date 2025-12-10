package com.lucascalabria.fight_strategy_planner.controller;

import com.lucascalabria.fight_strategy_planner.model.dto.FeedbackGetDTO;
import com.lucascalabria.fight_strategy_planner.model.dto.FeedbackPostDTO;
import com.lucascalabria.fight_strategy_planner.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackGetDTO> create(@RequestBody FeedbackPostDTO dto) {
        return ResponseEntity.ok(feedbackService.createFeedback(dto));
    }

    @GetMapping
    public ResponseEntity<List<FeedbackGetDTO>> getAll() {
        return ResponseEntity.ok(feedbackService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackGetDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackGetDTO> update(
            @PathVariable Long id,
            @RequestBody FeedbackPostDTO dto
    ) {
        return ResponseEntity.ok(feedbackService.updateFeedback(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
