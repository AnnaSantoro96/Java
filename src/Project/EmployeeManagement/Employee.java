package Project.EmployeeManagement;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary){
      setName(name);
      setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 0){
            throw new IllegalArgumentException("Invalid salary");
        }else{
        this.salary = salary;
    }
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        } else {
            this.name = name;
        }
    }

    public void displayInfo(){
        System.out.println("Name: " + name + "\nSalary: " + salary);
    }

    public void work() {
        System.out.println("Employee is working");
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}
