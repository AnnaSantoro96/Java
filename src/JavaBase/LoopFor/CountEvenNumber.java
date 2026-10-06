package JavaBase.LoopFor;

public class CountEvenNumber {
    static void main() {
        System.out.println("Count the even number inside a sequence from 1 to 100");

        int count = 0;
        for (int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                count++;
            }
        }

        System.out.println("The even number inside a sequence from 1 to 100 are " + count);
    }
}
