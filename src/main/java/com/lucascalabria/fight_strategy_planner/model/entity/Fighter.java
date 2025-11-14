package com.lucascalabria.fight_strategy_planner.model.entity;

import com.lucascalabria.fight_strategy_planner.model.enums.FightingStyle;
import com.lucascalabria.fight_strategy_planner.model.enums.WeightCategory;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "FIGHTER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fighter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "weight_category", nullable = false)
    private WeightCategory weightCategory;

    @Enumerated(EnumType.STRING)
    private FightingStyle fightingStyle;

    @Column(columnDefinition = "TEXT")
    private String recordSummary;

    @ManyToOne
    @JoinColumn(name = "coach_id", nullable = false)
    private Coach coach;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "fighter", cascade = CascadeType.ALL)
    private List<TacticalPlan> tacticalPlans;

    @OneToMany(mappedBy = "fighter", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "fighter", cascade = CascadeType.ALL)
    private List<PerformanceReport> performanceReports;

}
