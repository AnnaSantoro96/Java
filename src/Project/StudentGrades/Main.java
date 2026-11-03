package Project.StudentGrades;

public class Main {
    static void main() {
        StudentGrades studentGrades = new StudentGrades();

        studentGrades.addStudent("Anna", 20);
        studentGrades.addStudent("Luca", 30);
        studentGrades.addStudent("Marco", 21);

        IO.println("FIRST LIST");
        studentGrades.printStudents();
        IO.println();
        IO.println("Average grade");
        IO.println(studentGrades.getAverageGrade());
        IO.println("Anna's grade");
        IO.println(studentGrades.getGrade("Anna"));

        studentGrades.addStudent("Anna", 21);
        IO.println();
        IO.println("NEW LIST");
        studentGrades.printStudents();
    }
}
