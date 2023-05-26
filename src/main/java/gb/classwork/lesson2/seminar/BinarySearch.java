package gb.classwork.lesson2.seminar;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 10, 20, 30};
        System.out.println(binarySearch(arr, 10));
    }
    public static int binarySearch(int[] arr, int item){
        return binarySearch(arr, 0, arr.length-1, item);
    }
    public static int binarySearch(int[] arr, int beginIndex, int endIndex, int item){
        if(beginIndex <= endIndex){
            int middle = beginIndex + (endIndex - beginIndex)/2;
            if(arr[middle] > item)return binarySearch(arr, beginIndex, middle -1, item);
            else if(arr[middle] < item)return binarySearch(arr, middle+1, endIndex, item);
            else return middle;
        }
        else return -1;
    }
}
