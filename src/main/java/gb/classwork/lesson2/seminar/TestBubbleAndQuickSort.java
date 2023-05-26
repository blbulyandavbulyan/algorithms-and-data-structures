package gb.classwork.lesson2.seminar;

import java.util.Random;

import static gb.classwork.lesson2.seminar.QuickSort.quickSort;
public class TestBubbleAndQuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 10_000; i <= 100_000; i+=10_000) {
            int []arr = new int[i];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt();
            }
            long bubbleSortTime = System.currentTimeMillis();
            BubbleSort.bubbleSort(arr);
            bubbleSortTime = System.currentTimeMillis() - bubbleSortTime;
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt();
            }
            long quickSortTime = System.currentTimeMillis();
            quickSort(arr, 0, arr.length - 1);
            quickSortTime = System.currentTimeMillis() - quickSortTime;
            System.out.printf("Для %d: \n\tбыстрая сортировка: %d,\n\tпузырьковая сортировка: %d\n", i, quickSortTime, bubbleSortTime);
        }
    }
}
