package JavaBase.Exercices;

public class MultiplyingOddNumbers {
    static void main() {

        int tot = 1;
        for(int i = 1; i <= 15; i++){
            if(i % 2 == 1){
                tot *= i;
            }
        }

        System.out.println("Total: " + tot);
    }
}
