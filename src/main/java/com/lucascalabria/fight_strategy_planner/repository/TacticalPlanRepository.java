package com.lucascalabria.fight_strategy_planner.repository;

import com.lucascalabria.fight_strategy_planner.model.entity.TacticalPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacticalPlanRepository extends JpaRepository<TacticalPlan, Long> {

    /**
     * Finds all tactical plans associated with a specific fighter.
     * Implements User Story 1.3.
     *
     * @param fighterId The ID of the Fighter.
     * @return A list of TacticalPlans for that fighter.
     */
    List<TacticalPlan> findByFighterId(Long fighterId);
}