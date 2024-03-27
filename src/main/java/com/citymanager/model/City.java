package com.citymanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Min(0)
    private Long area;
    @Min(0)
    private Long population;
    @Min(0)
    private Long gdp;
    private String description;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
