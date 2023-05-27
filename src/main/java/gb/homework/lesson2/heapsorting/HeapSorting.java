package gb.homework.lesson2.heapsorting;

import gb.homework.lesson2.heap.Heap;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HeapSorting {
    static final Random random = new Random();
    static int[] generateRandomArray(int count){
        return IntStream.generate(()-> random.nextInt(-20, 20)).limit(count).toArray();
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] forHeapSort = generateRandomArray(100000);
        int[] forStandartSort = Arrays.copyOf(forHeapSort, forHeapSort.length);
//        printArray(forHeapSort);
        heapSort(forHeapSort);
        Arrays.sort(forStandartSort);
        if(Arrays.equals(forHeapSort, forStandartSort)){
            System.out.println("Отсортировано корректно!");
        }
        else {
            System.out.println("Отсортировано не корректно!");
            System.out.println("Heap sort: ");
            printArray(forHeapSort);
            System.out.println("Нормальная сортировка: ");
            printArray(forStandartSort);
        }
    }
    static public void heapSort(int[] values){
        Heap<Integer> integerHeap = new Heap<>(values.length);
        for (int i = 0; i < values.length; i++) {
            integerHeap.add(values[i]);
        }
        for (int i = values.length- 1; i >=0 ; i--) {
            values[i] = integerHeap.removeMax();
        }
    }
}
