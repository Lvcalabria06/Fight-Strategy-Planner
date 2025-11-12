package com.lucascalabria.fight_strategy_planner.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PERFORMANCE_REPORT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerformanceReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fighter_id", nullable = false)
    private Fighter fighter;

    @Column(name = "average_score", precision = 4, scale = 2)
    private BigDecimal averageScore;

    @Column(nullable = false)
    private String reportPeriod;

    @Column(nullable = false)
    private int totalPlans;

    @ManyToOne
    @JoinColumn(name = "best_plan_id")
    private TacticalPlan bestPlan;

    @Column(name = "generated_at", updatable = false)
    private LocalDateTime generatedAt = LocalDateTime.now();
}
