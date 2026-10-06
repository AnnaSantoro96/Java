package JavaBase.LoopFor;

public class ListNumber {
    static void main() {
        int [] numbers = {3, -1, 7, 0, 9};

        for(int n : numbers){
            if(n < 0){
                continue;
            }
            if(n == 0){
                break;
            }
            System.out.println(n);
        }
    }
}
