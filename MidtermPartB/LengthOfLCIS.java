package MidtermPartB;

public class LengthOfLCIS {

    public int findLongestLength(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i + 1]) {

                count++;
                max = Math.max(count, max);
            } else {

                count = 1;
            }
        }
        return max;
    }
}
