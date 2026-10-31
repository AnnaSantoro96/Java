package Project.EmployeeManagement;

public class Manager extends Employee {

    public Manager(String name, double salary){
        super(name, salary);
    }

    @Override
    public void work(){
        System.out.println("Manager is working");
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.15;
    }
}
