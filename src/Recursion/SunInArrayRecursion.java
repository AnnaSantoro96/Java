package Recursion;

public class SunInArrayRecursion {

    static int sum(int [] arr, int index){

        if(index >= arr.length) return 0;

        return arr[index] + sum(arr, index+1);

    }

    static void main() {
        int[] numeri = {2, 4, 6, 8};
        System.out.println("Somma: " + sum(numeri, 0));
    }
}
