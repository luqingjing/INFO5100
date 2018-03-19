package Assignment7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    @Test
    void findMedianSortedArrays() {

        MedianOfTwoSortedArrays ma = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[0];

        assertEquals(1.5, ma.findMedianSortedArrays(nums1, nums2));

        nums2 = new int[] {3, 4};
        assertEquals(2.5, ma.findMedianSortedArrays(nums1, nums2));

        nums1 = new int[] {2, 3, 4};
        assertEquals(3, ma.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void getKth() {

        MedianOfTwoSortedArrays ma = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;

        assertEquals(2, ma.getKth(nums1, 0, m - 1, nums2, 0, n - 1, left));
        assertEquals(3, ma.getKth(nums1, 0, m - 1, nums2, 0, n - 1, right));
    }
}