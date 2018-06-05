package practice;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class QuickSort {
    @Test
    public void test() {
        assertTrue(
                Arrays.equals(
                        new int[]{1, 5, 7, 8, 9, 10},
                        quickSort(new int[]{10, 7, 8, 9, 1, 5}, 0, 5)));
        assertTrue(
                Arrays.equals(
                        new int[]{0, 0, 0, 0, 1},
                        quickSort(new int[]{1, 0, 0, 0, 0}, 0, 4)));
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private int[] quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }

        return arr;
    }

    private int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}
