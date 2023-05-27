package gb.classwork.lesson4.binarysearchthree;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

public class TestBinarySearchTree {
    public static void main(String[] args) {
        Random random = new Random();
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

        Collection<Integer> randomKeys = Stream.generate(()->random.nextInt(0, 100)).limit(100000).distinct().toList();
        for (Integer key : randomKeys) {
            binarySearchTree.add(key, "Случайный ключ " + key);
        }
        for (Integer key : randomKeys) {
            System.out.printf("Случайный ключ: %d, значение %s\n", key, binarySearchTree.find(key));
        }
    }
}
