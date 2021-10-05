package com.example.heroku_rest_api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "cars")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String brand;

    @Column
    private String type;

    @Column
    private String model;

    @Column
    private int doors;

    @Column
    private int registrationNumber;
}
