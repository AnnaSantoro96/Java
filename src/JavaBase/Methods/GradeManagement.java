package JavaBase.Methods;

import java.util.Scanner;

public class GradeManagement {
    //Method that add grades in the array
    static int[] addGrade(){
        final int MAX_DIMENSION = 7;
        System.out.println("Enter max " + MAX_DIMENSION + " grades");
        Scanner in = new Scanner(System.in);

        int grades[] = new int [MAX_DIMENSION];
        for(int i = 0; i < MAX_DIMENSION; i++){
            grades[i] = in.nextInt();
        }

        return grades;
    }

    //Method that print all the grades added in the array
    static void printGrade(int [] grades){
        for(int grade : grades){
            System.out.println(grade);
        }
    }

    //Method that find the highest grade
    static int highestGrade(int [] grades){
        int max = grades[0];

        for(int i = 0; i < grades.length; i++){
            if(max < grades[i]){
                max = grades[i];
            }
        }

        return max;
    }

    //Method that find the lowest grade
    static int lowestGrade(int [] grades){
        int min = grades[0];

        for(int i = 0; i < grades.length; i++){
            if(min > grades[i]){
                min = grades[i];
            }
        }

        return min;
    }

    //Method that calculate the average
    static double averageGrade(int [] grades){
        double sum = 0;

        for(int grade : grades){
            sum = sum + grade;
        }

        double average = sum / grades.length;
        return average;
    }

    //Method that count how many grades are sufficient
    static int sufficientGrade(int [] grades){
        int count = 0;

        for(int i = 0; i < grades.length; i++){
            if(grades[i] >= 18){
                count++;
            }
        }

        return count;
    }

    //Method that cout how many grades are insufficient
    static int insufficientGrade(int [] grades){
        int count = 0;

        for (int i = 0; i < grades.length; i++){
            if(grades[i] < 18){
                count++;
            }
        }
        return count;
    }

    //Method that verify if tha average is at least 18
    static boolean atLeastEighteen(int [] grades){

        double average = averageGrade(grades);

        if(average >= 18){
            return true;
        }

        return false;
    }



    static void main() {
        //ADD GRADES
       int [] grades =  addGrade();

        //PRINT GRADES
        System.out.println(" ");
        System.out.println("You grades:");
        printGrade(grades);

        //PRINT THE HIGHEST GRADE
        System.out.println(" ");
        System.out.println("HIGHEST GRADE");
        int max = highestGrade(grades);
        System.out.println(max);

        //PRINT THE LOWEST GRADE
        System.out.println(" ");
        System.out.println("LOWEST GRADE");
        int min = lowestGrade(grades);
        System.out.println(min);

        //PRINT THE AVERAGE
        System.out.println(" ");
        System.out.println("AVERAGE GRADE");
        double avarage = averageGrade(grades);
        System.out.println(avarage);

        //PRINT HOW MANY GRADE ARE SUFFICIENT
        System.out.println(" ");
        System.out.println("NUMBER OF SUFFICIENT GRADES");
        int sufficientGrades = sufficientGrade(grades);
        System.out.println(sufficientGrades);

        //PRINT HOW MANY GRADE ARE INSUFFICIENT
        System.out.println(" ");
        System.out.println("NUMBER OF INSUFFICIENT GRADES");
        int insufficientGrades = insufficientGrade(grades);
        System.out.println(insufficientGrades);

        //VERIFY IF THE AVERAGE IS AT LEAST 18
        System.out.println(" ");
        System.out.println("IS THE AVERAGE AT LEAST EIGHTEEN?");
        boolean answer = atLeastEighteen(grades);
        System.out.println(answer);


    }
}
