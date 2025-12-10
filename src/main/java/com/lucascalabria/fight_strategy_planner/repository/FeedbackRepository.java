package com.lucascalabria.fight_strategy_planner.repository;

import com.lucascalabria.fight_strategy_planner.model.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {}
