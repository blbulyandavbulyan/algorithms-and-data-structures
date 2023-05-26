package gb.classwork.lesson1;

import java.util.Date;

import static java.lang.System.currentTimeMillis;

//Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
//        Считаем, что 1 и 2 значения последовательности равны 1.
//        Искать будем по формуле On=On-1+On-2 что предполагает использовать рекурсивного алгоритма.
public class Fibonaci {
    public static void main(String[] args) {

        test();
    }
    public static void test() {
        for (int i = 10; i <= 50; i = i + 10) {
            Date startDate = new Date();
            linealFindFibonaci(i);
            Date endDate = new Date();
            long lineDuration = endDate.getTime() - startDate.getTime();
            startDate = new Date();
            findFibonaci(i);
            endDate = new Date();
            long recursiveDuration = endDate.getTime() - startDate.getTime();
            System.out.printf("i: %s, line duration: %s, recursive duration: %s%n", i, lineDuration, recursiveDuration);
        }
    }
    public static int findFibonaci(int n){
        if(n <= 2){
            return 1;
        }
        return findFibonaci(n - 1) + findFibonaci(n - 2);
    }
    public static int linealFindFibonaci(int n){
        int result = 1;
        int previous = 1;
        int prePrevious = 1;
        for (int i = 2; i < n; i++) {
            result = previous + prePrevious;
            prePrevious = previous;
            previous = result;
        }
        return result;
    }
}
