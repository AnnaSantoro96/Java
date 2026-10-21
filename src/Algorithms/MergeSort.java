package Algorithms;

public class MergeSort {
    static void mergeSort(int [] array, int left, int rigth){
        if(left >= rigth) return;

        int mid = left + (rigth - left) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, rigth);
        merge(array, left, mid, rigth);
    }

    static void merge(int [] array, int left, int mid, int rigth){
        int n1 = mid - left + 1;
        int n2 = rigth - mid;

        int [] leftArray = new int[n1];
        int [] rigthArray = new int[n2];

        for(int i = 0; i < n1; i++){
            leftArray[i] = array[left + 1];
        }

        for(int j = 0; j < n2; j++){
            rigthArray[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = left;

        while (i < n1 && j < n2){
            if(leftArray[i] <= rigthArray[j]){
                array[k] = leftArray[i];
                i++;
            }else {
                array[k] = rigthArray[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2){
            array[k] = rigthArray[j];
            j++;
            k++;
        }

    }
    static void main() {
        int[] numbers = {6, 3, 8, 2};

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println(java.util.Arrays.toString(numbers));
    }
}
