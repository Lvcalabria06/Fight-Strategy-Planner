package com.lucascalabria.fight_strategy_planner.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TACTICAL_PLAN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TacticalPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PLANNED;

    public enum Status {
        PLANNED, IN_PROGRESS, COMPLETED
    }

    @ManyToOne
    @JoinColumn(name = "fighter_id", nullable = false)
    private Fighter fighter;

    @Column(columnDefinition = "TEXT")
    private String aiRecommendation;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "tacticalPlan", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "tacticalPlan", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;
}