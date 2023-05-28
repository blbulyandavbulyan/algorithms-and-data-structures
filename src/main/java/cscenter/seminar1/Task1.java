package cscenter.seminar1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        //найти наибольшую по длине возрастающую последовательность в массиве
        System.out.println(findLongestSubsequenceInArray(new int[]{10, 0, 11, 1, 12, 2, 3, 4}));
    }
    public static List<Integer> findLongestSubsequenceInArray(int[] arr){
        List<Integer> result = new ArrayList<>(arr.length);
        List<Integer> temporalStorage = new ArrayList<>(arr.length);
        for(int i = 0; i < arr.length; i++){
            temporalStorage.add(arr[i]);
            for (int j = i; j < arr.length; j++) {
                if(arr[j] > temporalStorage.get(temporalStorage.size() - 1)){
                    temporalStorage.add(arr[j]);
                }
            }
            if(result.size() < temporalStorage.size()){
                result.clear();
                result.addAll(temporalStorage);
            }
            temporalStorage.clear();
        }
        return result;
    }
}
