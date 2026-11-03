package Project.StudentGrades;

import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    private HashMap<String, Integer> grades;

    public StudentGrades(){
        grades = new HashMap<>();
    }

    public void addStudent(String name, int grade){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }

        if(grade < 0 || grade > 30){
            throw new IllegalArgumentException("Invalid grade");
        }

        grades.put(name, grade);
    }

    public void removeStudent(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }
        if(grades.isEmpty()){
            IO.println("The list is empty");
            return;
        }

        grades.remove(name);
    }

    public int getGrade(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name");
        }

        if(!grades.containsKey(name)){
            throw new IllegalArgumentException(name + " is not present");
        }

        int grade = grades.get(name);
        return grade;
    }



    public void printStudents(){
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public double getAverageGrade(){
        double total = 0;

        if(grades.isEmpty()){
            IO.println("The list is empty");
            return 0;
        }

        for(Integer grade : grades.values()){
            total = total + grade;
        }

        return total / grades.size();
    }
}
