package JavaBase.Array;

public class MinMax {
    static void main() {

        int numbers[] = {12, 33, 2, 4, 89, 12, 1};
        int min = numbers[0];
        int max = numbers[0];
        int length = numbers.length;

        for(int num : numbers){
            if(min > num){
                min = num;
            }
            if(max < num){
                max = num;
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
