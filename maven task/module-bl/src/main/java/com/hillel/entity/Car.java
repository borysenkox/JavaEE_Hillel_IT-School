package com.hillel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Car {
    private String manufacture;
    private String model;
    private int yearOfManufacture;
    private int topSpeed;
}
