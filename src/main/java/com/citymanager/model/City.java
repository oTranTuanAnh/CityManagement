package com.citymanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    private int population;
    private double gdp;
    private String description;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
