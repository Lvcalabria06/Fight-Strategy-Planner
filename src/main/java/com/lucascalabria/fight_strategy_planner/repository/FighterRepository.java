package com.lucascalabria.fight_strategy_planner.repository;

import com.lucascalabria.fight_strategy_planner.model.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
    boolean existsByName(String name);
}