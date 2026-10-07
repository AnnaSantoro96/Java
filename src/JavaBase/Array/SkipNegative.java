package JavaBase.Array;

public class SkipNegative {
    static void main() {

        int numbers[] = {2, 3, -3, 56, -5, 0, 10};
        int length = numbers.length;

        for(int num : numbers){
            if(num < 0){
                continue;
            } else if (num == 0) {
                break;
            }

            System.out.println(num);
        }
    }
}
