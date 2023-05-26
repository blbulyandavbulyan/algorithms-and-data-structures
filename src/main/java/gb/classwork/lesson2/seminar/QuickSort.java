package gb.classwork.lesson2.seminar;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int []arr, int beginIndex, int endIndex){
        int pivot = arr[beginIndex + (endIndex - beginIndex)/2];
        int leftPosition = beginIndex;
        int rightPosition = endIndex;
        while (leftPosition <= rightPosition){
            while (arr[leftPosition] < pivot)leftPosition++;
            while (arr[rightPosition] > pivot)rightPosition--;
            if(leftPosition <= rightPosition){
                if(leftPosition < rightPosition){
                    int temp = arr[leftPosition];
                    arr[leftPosition] = arr[rightPosition];
                    arr[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }
        if(leftPosition < endIndex)
            quickSort(arr, leftPosition, endIndex);
        if(rightPosition > beginIndex)
            quickSort(arr, beginIndex, rightPosition);
    }

    public static void main(String[] args) {
        int[] arr = {120, 7, 3, 130, 0, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
