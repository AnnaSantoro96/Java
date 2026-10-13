package JavaBase.Methods;

public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;

                    return index;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] index = twoSum(nums, target);

        System.out.println(index[0] + ", " + index[1]);
    }
}
