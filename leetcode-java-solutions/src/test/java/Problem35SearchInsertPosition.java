import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem35SearchInsertPosition {
    @Test
    public void testSearchInsertPosition() {
        assertEquals(2, searchInsertPosition(new int[]{ 1, 3, 5, 6 }, 5));
        assertEquals(1, searchInsertPosition(new int[]{ 1, 3, 5, 6 }, 2));
        assertEquals(4, searchInsertPosition(new int[]{ 1, 3, 5, 6 }, 7));
        assertEquals(0, searchInsertPosition(new int[]{ 1, 3, 5, 6 }, 0));
        assertEquals(1, searchInsertPosition(new int[]{ 1, 3 }, 2));
        assertEquals(0, searchInsertPosition(new int[]{ 1, 3 }, 1));
        assertEquals(1, searchInsertPosition(new int[]{ 1, 3 }, 3));
        assertEquals(2, searchInsertPosition(new int[]{ 1, 3 }, 4));
        assertEquals(2, searchInsertPosition(new int[]{ 1, 3, 5 }, 4));
    }

    private int searchInsertPosition (int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        int mid;

        while (start < end) {
            mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
