package JavaBase.Exercices;

import com.sun.jdi.IntegerValue;

import java.util.Scanner;

public class FootbalMatch {
    static void main() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the name of the first team");
        String team1 = in.nextLine();

        System.out.println("Enter the name of the second team");
        String team2 = in.nextLine();

        System.out.println("Enter the goal number of the first team");
        String goal1 = in.nextLine();

        System.out.println("Enter the goal of the second team");
        String goal2 = in.nextLine();

        if(Integer.valueOf(goal1).intValue() > Integer.valueOf(goal2).intValue()){
            System.out.println(team1 + " win!");
        } else if (Integer.valueOf(goal1).intValue() < Integer.valueOf(goal2).intValue()) {
            System.out.println(team2 + " win!");
        }else{
            System.out.println("Draw!");
        }

        int totalGoal = Integer.valueOf(goal1).intValue() + Integer.valueOf(goal2).intValue();
        System.out.println("Total goal : " + totalGoal);
    }
}
