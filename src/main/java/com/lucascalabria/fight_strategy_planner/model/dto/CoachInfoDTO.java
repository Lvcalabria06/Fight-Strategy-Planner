package com.lucascalabria.fight_strategy_planner.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoachInfoDTO {
    private Long id;
    private String name;
    private String gymName;

    public CoachInfoDTO(Long id, String name, String gymName) {
        this.id = id;
        this.name = name;
        this.gymName = gymName;
    }
}
