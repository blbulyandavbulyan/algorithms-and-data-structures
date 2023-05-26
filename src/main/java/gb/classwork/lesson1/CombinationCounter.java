package gb.classwork.lesson1;
/*

        Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество) для количества кубиков K с количеством граней N.
        У вас есть 2 варианта на выбор – количество кубиков может быть строго ограничено (4 кубика, например), либо их количество будет динамическим.
         Выбор за вами.
        Если вы реализуете простой вариант, обращает внимание, что данное решение имеет сложность O(n4), но если количество кубиков сделать переменной, то она трансформируется в O(nk),
         что будет представлять собой экспоненциальную сложность. Для второго решения очевидно, что его сложность O(nk) с самого начала.
*/
public class CombinationCounter {
    public static void main(String[] args) {

    }
    //найти количество комбинаций для 4 кубиков
    public static int findCountOfPossibleCombinations(int countOfSides){
        int result = 0;
        for (int i = 1; i <= countOfSides; i++) {
            for (int j = 1; j <= countOfSides; j++) {
                for (int k = 1; k <= countOfSides; k++) {
                    for (int l = 1; l <= countOfSides; l++) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public static int combinationCount(int count, int faces) {
        if (count > 0) {
            return recursiveCounter(1, count, faces);
        } else {
            return 0;
        }
    }

    private static int recursiveCounter(int depth, int maxDepth, int faces) {
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            if (depth == maxDepth) {
                count++;
            } else {
                count += recursiveCounter(depth + 1, maxDepth, faces);
            }
        }
        return count;
    }
}
