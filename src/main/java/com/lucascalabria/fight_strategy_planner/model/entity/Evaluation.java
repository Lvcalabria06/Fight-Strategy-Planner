package com.lucascalabria.fight_strategy_planner.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVALUATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evaluation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tactical_plan_id", nullable = false)
    private TacticalPlan tacticalPlan;

    private int technique;
    private int endurance;
    private int focus;

    @Column(name = "average_score", precision = 4, scale = 2)
    private Double averageScore;

    @Column(name = "evaluation_date", updatable = false)
    private LocalDateTime evaluationDate = LocalDateTime.now();
}
