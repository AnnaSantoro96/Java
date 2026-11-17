package JavaBase.Generics.NumericStorage;

import java.util.List;

public class Main {
    static void main() {

        NumericStorage<Integer> n1 = new NumericStorage<>(10);
        NumericStorage<Double> n2 = new NumericStorage<>(15.5);

        IO.println(n1.getNumber());
        IO.println(n2.doubleValue());
        IO.println();
        List<Integer> integers = List.of(10, 20, 30);

        List<Double> doubles = List.of(10.5, 20.5, 30.5);

        IO.println("Somma");
        System.out.println(Calculator.calculateSum(integers));
        System.out.println(Calculator.calculateSum(doubles));
        IO.println();

        IO.println("Media");
        System.out.println(Calculator.calculateAverage(integers));
        System.out.println(Calculator.calculateAverage(doubles));
    }
}
