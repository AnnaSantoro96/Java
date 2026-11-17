package JavaBase.Generics.NumericStorage;

import java.util.List;

public class Calculator {
    public static double calculateSum(List<? extends Number> numbers){
        double sum = 0;

        for(Number number : numbers){
            sum += number.doubleValue();
        }
        return sum;
    }

    public static double calculateAverage(List<? extends Number> numbers){
        double sum = 0;

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("La lista è vuota");
        }

        for(Number number : numbers){
            sum += number.doubleValue();
        }
        return sum/numbers.size();
    }
}
