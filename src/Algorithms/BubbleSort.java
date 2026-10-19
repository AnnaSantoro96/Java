package Algorithms;

public class BubbleSort {
    static void bubbleSort(int [] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }


    }

    //BUBBLE SORT OPTIMIZED
    static boolean bubbleSortOptimized(int [] array) {
        boolean swapped = false;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - 1 - i; i++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        return false;
    }


    static void main() {
        int [] array = {6, 3, 8, 2, 5};
        boolean bubbleSortOptimized = bubbleSortOptimized(array);
        System.out.println(bubbleSortOptimized);
    }
}
