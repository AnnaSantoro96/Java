package JavaBase.Array;

public class LowesAge {
    static void main(String[] args) {

        int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
        int length = ages.length;

        int min = ages[0];

        for(int age : ages){
            if(min > age){
                min = age;
            }
        }

        // Output the value of the lowest age
        System.out.println("The lowest age in the array is: " + min);
    }
}
