package Project.EmployeeManagement;

import java.util.ArrayList;

public class Main {
    static void main() {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Developer("Anna", 1800, "Java"));
        employees.add(new Developer("Luca", 2000, "C"));
        employees.add(new Manager("Paolo", 2500));
        employees.add(new Manager("Elisa", 2200));

        for (Employee employee : employees){
            employee.work();
            employee.displayInfo();
            System.out.println("Bonus: " + employee.calculateBonus());
        }
    }
}
