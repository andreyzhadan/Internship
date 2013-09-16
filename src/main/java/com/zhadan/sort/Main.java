package com.zhadan.sort;

/**
 * Created with IntelliJ IDEA.
 * User: azhadan
 * Date: 9/16/13
 * Time: 2:20 PM
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] array = {60, 22, 2, 3, 7, 10, 8, 6, 1, 7, 7};
        print(array);

        QuickSort sorter = new QuickSort();
        sorter.sort(array);

        print(array);
    }

    public static void print(int[] array) {
        System.out.println("\n");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("\n");
    }
}
