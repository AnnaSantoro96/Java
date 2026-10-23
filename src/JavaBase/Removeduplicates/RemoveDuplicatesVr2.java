package JavaBase.Removeduplicates;

public class RemoveDuplicatesVr2 {
    static int[] removeDuplicates(int[] numbers) {
        int[] tmp = new int[numbers.length];
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            boolean found = false;

            for (int j = 0; j < count; j++) {
                if (numbers[i] == tmp[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                tmp[count] = numbers[i];
                count++;
            }
        }

        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            result[i] = tmp[i];
        }

        return result;
    }

    static void main() {
        int [] numbers = {2, 4, 2, 7, 4, 9};

        int [] duplicates = removeDuplicates(numbers);

        for(int n : duplicates){
            IO.println(n);
        }
    }
}
