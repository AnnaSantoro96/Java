package JavaBase.Array;

public class AverageAge {
    static void main(String[] args) {

        //AN ARRAY STORING THE DIFFERENT AGE
        int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};

        float average = 0;
        float sum = 0;

        //LENGTH OF THE ARRAY
        int length = ages.length;

        for(int age : ages){
            sum += age;
        }

        average = sum / length;

        System.out.println("The average age is " + average);
    }
}
