package JavaBase.Removeduplicates;

import java.util.Scanner;

public class RemoveDuplicates {
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

    //Method that remove duplicates
    static int[] removeDuplicates(int[] firstArray) {
        int[] secondArray = {};

        for (int i = 0; i < firstArray.length; i++) {
            boolean found = false;

            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                int[] tmp = new int[secondArray.length + 1];

                for (int k = 0; k < secondArray.length; k++) {
                    tmp[k] = secondArray[k];
                }

                tmp[secondArray.length] = firstArray[i];
                secondArray = tmp;
            }
        }

        return secondArray;
    }

    static void main() {
        int [] firstArray = addElement();
        IO.println("First Array elements");
        for(int el : firstArray){
            IO.println(el);
        }

        System.out.println();
        int [] secondArray = removeDuplicates(firstArray);
        IO.println("Second Array elements");
        for(int el : secondArray){
            IO.println(el);
        }
    }
}
