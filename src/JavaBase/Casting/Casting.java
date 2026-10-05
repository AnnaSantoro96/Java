package JavaBase.Casting;

public class Casting {
    static void main() {
        //SET THE MAXIMUM POSSIBLE SCORE IN THE GAME TO 500
        int maxScore = 500;

        //ACTUAL SCORE OF THE USER
        int userScore = 423;

        /*
        CALCULATE THE PERCANTAGE OF THE USER'S SCORE IN RELATION TO THE MAXIMUM AVAILABLE SCORE.
        CONVERT USERSCORE TO DOUBLE TO MAKE SURE THAT THE DIVISION IS ACCURATE
        * */
        double percentage = (double) userScore / maxScore * 100.0d;

        //PRINT THE RESULT
        System.out.println("User's percentage is " + percentage);
    }
}
