package JavaBase.Array;

public class CountEvenNumbers {
    static void main() {
        System.out.println("Count how many even numbers are present.");

        int numbers[] = {12, 3, 5, 22, 10, 15};
        int count = 0;

        for (int num : numbers){
            if(num % 2 == 0){
                count++;
            }
        }

        System.out.println("Are present " + count + " even numbers");
    }
}
