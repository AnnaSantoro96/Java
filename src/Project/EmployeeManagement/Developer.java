package Project.EmployeeManagement;

public class Developer extends Employee{

    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage){
        super(name, salary);
        setProgrammingLanguage(programmingLanguage);
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        if (programmingLanguage == null || programmingLanguage.isBlank()) {
            throw new IllegalArgumentException("Invalid value");
        } else {
            this.programmingLanguage = programmingLanguage;
        }
    }

    public void displayProgrammingLanguage(){
        System.out.println("Programming Language: " + programmingLanguage);
    }

    @Override
    public void work(){
        System.out.println("Developer is writing code");
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10;
    }
}
