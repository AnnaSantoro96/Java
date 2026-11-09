package Project.EcommerceManagementSystem.model;

public class Admin extends User{
    private String department;
    private String employeeCode;

    public Admin(String id, String name, String lastName, String email, String department, String employeeCode){
        super(id, name, lastName, email);
        setDepartment(department);
        setEmployeeCode(employeeCode);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department == null || department.isBlank()){
            throw new IllegalArgumentException("Invalid department");
        }
        this.department = department;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        if(employeeCode == null || employeeCode.isBlank()){
            throw new IllegalArgumentException("Invalid employee code");
        }
        this.employeeCode = employeeCode;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + department + "\nEmployee Code: " + employeeCode;
    }
}
