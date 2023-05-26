package gb.classwork.lesson1;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
//        System.out.println(findSumOfArray(10));
        List<Integer> simpleNumbers = findSimpleNumbers(150);
        for(int i = 0; i < simpleNumbers.size(); i++){
            System.out.println(simpleNumbers.get(i));
        }
    }
    //Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
    // Согласно свойствам линейной сложности, количество итераций цикла будет линейно изменяться относительно изменения размера N.
    //
    public static int sumOfNumbersFromOneTo(int n){
        int result = 0;
        for(int i = 1; i <= n; i++)result+=i;
        return result;
    }
    //поиск простых чисел
    public static List<Integer> findSimpleNumbers(int n){
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isSimple = false;
                    break;
                }
            }
            if(isSimple){
                result.add(i);
            }
        }
        return result;
    }
}
