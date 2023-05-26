package gb.classwork.lesson2.seminar;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for (int j = arr.length; j > 1; j--) {
            for (int i = 0; i < j - 1; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 0, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
