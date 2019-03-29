package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private int id;
    private String firstName;
    private String lastName;

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}