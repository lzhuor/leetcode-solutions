import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem4MedianOfTwoSortedArrays {
    @Test
    public void test() {
        double precision = 0.0001;
        assertEquals(4.5, findMedianSortedArrays(new int[]{3, 5, 10}, new int[]{1, 4, 6}), precision);
        assertEquals(5, findMedianSortedArrays(new int[]{3, 5, 10}, new int[]{}), precision);
        assertEquals(3, findMedianSortedArrays(new int[]{3, 5, 10}, new int[]{0, 1}), precision);
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int[] merge = merge(nums1, nums2);
        final int length = merge.length;
        final int i = length / 2;
        if (length % 2 == 0) {
//            System.out.println(merge[i] + " " + merge[i - 1]);
            return (double) (merge[i] + merge[i - 1]) / 2.0;
        } else {
            return merge[i];
        }
    }

    private int[] merge(int[] a, int[] b) {
        int l1 = a.length;
        int l2 = b.length;
        int[] merge = new int[l1 + l2];
        int index = 0, i = 0, j = 0;
        while (index < l1 + l2) {
            if (i >= l1) {
                merge[index++] = b[j++];
            } else if (j >= l2) {
                merge[index++] = a[i++];
            } else if (a[i] <= b[j]) {
                merge[index++] = a[i++];
            } else {
                merge[index++] = b[j++];
            }
        }
        return merge;
    }
}
