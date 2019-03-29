import entity.Car;
import entity.Employee;

public class Domain {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Sergey");
        employee.setLastName("Borysenko");

        Car car = new Car();
        car.setManufacture("Tesla");
        car.setModel("Model X");
        car.setYearOfManufacture(2019);
        car.setTopSpeed(210);

        System.out.println(employee);
        System.out.println(car);
    }

}