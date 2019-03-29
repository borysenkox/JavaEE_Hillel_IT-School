package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private String manufacture;
    private String model;
    private int yearOfManufacture;
    private int topSpeed;

    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" + manufacture + " " + model + " " + yearOfManufacture
                + " Top Speed " + topSpeed + " km/h}";
    }

}