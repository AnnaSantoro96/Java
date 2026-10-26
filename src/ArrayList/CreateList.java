package ArrayList;

import java.util.ArrayList;

public class CreateList {
    static void main() {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        numbers.add(5);
        numbers.set(1, 99);

        for(int i = 0; i < numbers.size(); i++){
            System.out.println(numbers.get(i));
        }

        System.out.println("Dimensione: " + numbers.size());
    }
}
