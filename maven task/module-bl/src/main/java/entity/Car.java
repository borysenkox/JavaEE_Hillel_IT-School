package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car {
    private String manufacture;
    private String model;
    private int yearOfManufacture;
    private int topSpeed;

    @Override
    public String toString() {
        return "Car{" + manufacture + " " + model + " " + yearOfManufacture
                + " Top Speed " + topSpeed + " km/h}";
    }

}