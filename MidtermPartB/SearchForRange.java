package MidtermPartB;

public class SearchForRange {

    public int[] searchForRange(int[] nums, int target) {

        int[] range = {nums.length, -1};
        binarySearch(nums, target, 0, nums.length - 1, range);

        if (range[0] > range[1])
            range[0] = -1;
        return range;
    }

    public void binarySearch(int[] nums, int target, int left, int right, int[] range) {

        if (left > right)
            return;

        int mid = (left + right)/2;

        if (nums[mid] == target) {

            if (mid < range[0]) {

                range[0] = mid;
                binarySearch(nums, target, left, mid - 1, range);
            }

            if (mid > range[1]) {

                range[1] = mid;
                binarySearch(nums, target, mid + 1, right, range);
            }
        } else if (nums[mid] > target) {
            binarySearch(nums, target, left, mid - 1, range);
        } else {
            binarySearch(nums, target, mid + 1, right, range);
        }
    }
}
