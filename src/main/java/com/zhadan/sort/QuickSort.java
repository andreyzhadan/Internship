package com.zhadan.sort;

/**
 * Created with IntelliJ IDEA.
 * User: azhadan
 * Date: 9/16/13
 * Time: 2:18 PM
 */
public class QuickSort {
    private int[] array;

    public void sort(int[] array) {
        this.array = array;
        quickSort(0, array.length - 1);
    }

    public void quickSort(int left, int right) {
        if (left >= right)
            return;
        int i = left;
        int j = right;
        int pivot = array[(i + j) / 2];
        System.out.print("pivot " + pivot + " ");
        while (i < j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(left, j);
        quickSort(i, right);
    }
}

