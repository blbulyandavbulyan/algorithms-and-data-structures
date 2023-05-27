package gb.classwork.lesson4.binarysearchthree;

import gb.classwork.lesson4.binarysearchthree.exceptions.KeyNotFoundException;

import java.util.Collection;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBinarySearchTree {
    public static void main(String[] args) {
        Random random = new Random();
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

        Collection<Integer> randomKeys = Stream.generate(()->random.nextInt(0, 100)).limit(10).distinct().collect(Collectors.toList());
        System.out.println(randomKeys);
        for (Integer key : randomKeys) {
            binarySearchTree.add(key, "Случайный ключ " + key);
        }
        for (Integer key : randomKeys) {
            System.out.printf("Случайный ключ: %d, значение %s\n", key, binarySearchTree.find(key));
        }
        Scanner scanner = new Scanner(System.in);
        while (!randomKeys.isEmpty()){
            System.out.println("Введите ключ чтобы удалить: ");
            Integer keyForDelete = scanner.nextInt();
            try {
                binarySearchTree.remove(keyForDelete);
                randomKeys.remove(keyForDelete);
            }
            catch (KeyNotFoundException e){
                System.out.println("Ключа " + keyForDelete + " в бинарном дереве нет!");
            }

        }
    }
}
