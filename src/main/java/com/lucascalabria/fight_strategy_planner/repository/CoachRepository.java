package com.lucascalabria.fight_strategy_planner.repository;

import com.lucascalabria.fight_strategy_planner.model.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
