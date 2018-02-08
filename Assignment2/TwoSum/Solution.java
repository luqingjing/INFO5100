// scores : 4 / 4 

package Assignment2.TwoSum;

import java.util.Hashtable;

public class Solution {

    // Time complexity: O(n^2).
    // Space complexity: O(1).
    public int[] twoSum1(int[] nums, int target) {

        int[] index = new int[2];

        // An n loop is used. The time complexity here is O(n).
        for (int i = 0; i < nums.length - 1; i++) {

            // Another n loop is used. The time complexity here is O(n^2).
            for (int j = i + 1; j < nums.length; j++) {

                if (target == nums[i] + nums[j]) {

                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        // None extra space used. The space complexity is O(1).
        return index;
    }

    // Time complexity: O(n).
    // Space complexity: O(n).
    public int[] twoSum2(int[] nums, int target) {

        // The extra space required depends on the number of items stored in the hash table,
        // which stores n elements, so the space complexity here is O(n).
        Hashtable hash = new Hashtable();
        int[] index = new int[2];

        // An n loop is used. The time complexity here is O(n).
        for (int i = 0; i < nums.length; i++) {

            if (hash.containsKey(nums[i])) {

                index[0] = (int)hash.get(nums[i]);
                index[1] = i;
                break;
            } else {

                hash.put(target - nums[i], i) ;
            }

        }
        return index;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 45, 6, 10, -8};
        int target = 37;
        Solution n = new Solution();
//        int[] result = n.twoSum1(nums,target);
        int[] result = n.twoSum2(nums,target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
