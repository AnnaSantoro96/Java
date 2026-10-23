package Recursion;

public class CountEven {

    static int countEven(int [] arr, int index){
        if(index >= arr.length) return 0;

        if(arr[index] % 2 == 0){

            return 1 + countEven(arr, index+1);
        }

            return 0 + countEven(arr, index+1);
    }

    static void main() {
        int[] numeri = {3, 8, 4, 7, 2};
        System.out.println("Even Number: " + countEven(numeri, 0));
    }
}
