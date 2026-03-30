package Array;

import java.util.HashMap;

public class LC1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prev = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int diff = target - n;

            if (prev.containsKey(diff)) {
                return new int[]{prev.get(diff), i};
            }
            prev.put(n, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found");
        }
    }
}