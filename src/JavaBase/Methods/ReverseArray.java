package JavaBase.Methods;

public class ReverseArray {

    static int[] reverseArray(int [] arr){
        int [] reverse = new int[arr.length];
        int j = 0;

        for (int i = arr.length-1; i >= 0; i--){
            reverse[j] = arr[i];
            j++;
        }

        return reverse;
    }

    static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        int [] reverse = reverseArray(arr);

        System.out.println("Array");
        for(int numbers : arr){
            IO.println(numbers);
        }

        IO.println();
        IO.println("Reverse array");
        IO.println(reverse);
    }
}
