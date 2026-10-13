package JavaBase.NumberAnalyzer;

import java.util.Scanner;

public class NumberAnalyzer {

    //Method that add an element in the array
    static int[] addElement(){
        Scanner in = new Scanner(System.in);
        IO.println("How many elements do you want add?");
        int dimension = in.nextInt();
        while(dimension < 1){
            IO.println("ERROR...The value must be > 0");
            dimension = in.nextInt();
        }

        int [] elements = new int[dimension];
        IO.println("Enter " + dimension + " elements");
        for(int i = 0; i < dimension; i++){
            int el = in.nextInt();
            elements[i] = el;
        }

        return elements;
    }

    //Method that return the sum of all elements
    static int sum(int [] elements){
        int sum = 0;
        for(int el : elements){
            sum += el;
        }

        return sum;
    }

    //Method that return the average of the elements
    static double average(int [] elements){
        int dimension = elements.length;
        int sum = sum(elements);
        double average = (double) sum / dimension;

        return  average;
    }

    //Method that return the max number
    static int max(int [] elements){
        int max = elements[0];
        for(int i = 0; i < elements.length; i++){
            if(elements[i] > max){
                max = elements[i];
            }
        }

        return max;
    }

    //Method that return the min number
    static int min(int [] elements){
        int min = elements[0];
        for(int i = 0; i < elements.length; i++){
            if(elements[i] < min){
                min = elements[i];
            }
        }

        return min;
    }

    //Method that count the even numbers
    static int countEven(int [] elements){
        int count = 0;

        for(int i = 0; i < elements.length; i++){
            if(elements[i] % 2 == 0){
                count++;
            }
        }

        return count;
    }

    //Method that count the odd numbers
    static int countOdd(int [] elements){
        int count = 0;
        for(int i = 0; i < elements.length; i++){
            if(elements[i] % 2 != 0){
                count++;
            }
        }

        return count;
    }

    static void main() {
        //ADD ELEMENTS
        int [] elements = addElement();

        //SUM OF THE ELEMENTS
        IO.println(" ");
        int sum = sum(elements);
        IO.println("The sum of the all elements present in the array is " + sum);

        //AVERAGE OF THE ELEMENTS
        IO.println(" ");
        double average = average(elements);
        IO.println("The average of the elements present in the array is " + average);

        //MAX NUMBER
        IO.println(" ");
        int max = max(elements);
        IO.println("The max number present in the array is " + max);

        //MIN NUMBER
        IO.println(" ");
        int min = min(elements);
        IO.println("The min number present in the array is " + min);

        //COUNT EVEN NUMBER
        IO.println(" ");
        int even = countEven(elements);
        IO.println("Even elements present in the array are " + even);

        //COUNT ODD ELEMENTS
        IO.println(" ");
        int odd = countOdd(elements);
        IO.println("Odd elements present in the array are " + odd);
    }
}
