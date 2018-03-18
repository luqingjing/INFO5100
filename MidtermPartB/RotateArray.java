package MidtermPartB;

public class RotateArray {

    public void rotateArray(int[] nums, int d, int n) {

        d %= n;
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);
        reverse(nums, 0, n - 1);
    }

    public void reverse(int[] nums, int low, int high) {

        while (low < high) {

            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
