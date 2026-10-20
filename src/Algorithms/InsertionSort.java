package Algorithms;

public class InsertionSort {

    static void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            int key = nums[i];
            int j = i - 1;

            // 1. Scrivi la condizione del while
            while(j >= 0 && nums[j] > key){
                // 2. Sposta a destra gli elementi più grandi
                nums[j+1] = nums[j];
                // 3. Decrementa j
                j--;
            }

            // 4. Inserisci key nella posizione corretta
            nums[j+1] = key;
        }
    }

}
