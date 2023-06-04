package gb.classwork.lesson4.binarysearchtree;

import gb.classwork.lesson4.binarysearchtree.BinarySearchTree;
import gb.classwork.lesson4.binarysearchtree.exceptions.KeyAlreadyAddedException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
public class BinarySearchTreeTest {
    private Random random = new Random();
    private int[] generateRandomArray(int count){
        return IntStream.generate(random::nextInt).distinct().limit(count).toArray();
    }
    private static class BinarySearchTreeAndData{
        private BinarySearchTree tree;
        private int[] data;

        public BinarySearchTreeAndData(BinarySearchTree tree, int[] data) {
            this.tree = tree;
            this.data = data;
        }
    }
    private BinarySearchTreeAndData generateRandomFilledTree(int count){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] arr = generateRandomArray(count);
        for(int i : arr){
            binarySearchTree.add(i);
        }
        return new BinarySearchTreeAndData(binarySearchTree, arr);
    }
    @Test void containsTest(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(20);
        binarySearchTree.add(200);
        binarySearchTree.add(150);
        assertTrue(binarySearchTree.find(20));
        assertTrue(binarySearchTree.find(200));
        assertTrue(binarySearchTree.find(150));
        assertTrue(binarySearchTree.find(100));
    }
    @Test void notContains(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(20);
        binarySearchTree.add(103);
        assertFalse(binarySearchTree.find(100));
    }
    @Test void addAlreadyExistingKey(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(100);
        binarySearchTree.add(120);
        assertThrows(KeyAlreadyAddedException.class, ()->{
            binarySearchTree.add(100);
        });
    }
    @Test
    public void containsRandomAddedElements(){
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(100);
        for(int i : binarySearchTreeAndData.data){
            assertTrue(binarySearchTreeAndData.tree.find(i), "Дерево не содержит %d, входные данные: %s".formatted(i, Arrays.toString(binarySearchTreeAndData.data)));
        }
    }
    @Test void treeIterator(){
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(100);
        Collection<Integer> values = StreamSupport.stream(binarySearchTreeAndData.tree.spliterator(), false).map((n)->n.value).toList();
        if(values.size() != binarySearchTreeAndData.data.length)fail("Размеры входного массива и тех данных что выдал итератор отличаются! Входные данные: %s".formatted(Arrays.toString(binarySearchTreeAndData.data)));
        else{
            for (int i : binarySearchTreeAndData.data){
                assertTrue(values.contains(i), "Значения по итератору не содержат %d, входные данные: %s".formatted(i, Arrays.toString(binarySearchTreeAndData.data)));
            }
        }
    }
    @Test void redNodesAreOnlyRightChildren(){

    }
}
