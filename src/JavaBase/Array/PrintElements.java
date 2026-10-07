package JavaBase.Array;

public class PrintElements {
    static void main() {
        int numbers[] = {2, 4, 12, 5};

        System.out.println("NORMAL FOR");
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

        System.out.println(" ");
        System.out.println("FOR-EACH");
        for(int num : numbers){
            System.out.println(num);
        }
    }
}
