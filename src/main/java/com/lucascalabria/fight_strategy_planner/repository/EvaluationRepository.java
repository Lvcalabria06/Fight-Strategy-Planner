package com.lucascalabria.fight_strategy_planner.repository;

import com.lucascalabria.fight_strategy_planner.model.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
