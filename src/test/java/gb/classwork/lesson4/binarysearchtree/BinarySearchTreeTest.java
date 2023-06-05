package gb.classwork.lesson4.binarysearchtree;

import gb.classwork.lesson4.binarysearchtree.BinarySearchTree;
import gb.classwork.lesson4.binarysearchtree.exceptions.KeyAlreadyAddedException;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
public class BinarySearchTreeTest {
    private final Random random = new Random();
    private final int defaultDataSize = random.nextInt(0,200);
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
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(defaultDataSize);
        for(int i : binarySearchTreeAndData.data){
            assertTrue(binarySearchTreeAndData.tree.find(i), "Дерево не содержит %d, входные данные: %s".formatted(i, Arrays.toString(binarySearchTreeAndData.data)));
        }
    }
    @Test void treeIterator(){
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(defaultDataSize);
        Collection<Integer> values = StreamSupport.stream(binarySearchTreeAndData.tree.spliterator(), false).map((n)->n.value).toList();
        if(values.size() != binarySearchTreeAndData.data.length)fail("Размеры входного массива и тех данных что выдал итератор отличаются! Входные данные: %s".formatted(Arrays.toString(binarySearchTreeAndData.data)));
        else{
            for (int i : binarySearchTreeAndData.data){
                assertTrue(values.contains(i), "Значения по итератору не содержат %d, входные данные: %s".formatted(i, Arrays.toString(binarySearchTreeAndData.data)));
            }
        }
    }
    @Test void redNodesDoesNotHaveRedParent(){
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(defaultDataSize);
        for (TreeNode node : binarySearchTreeAndData.tree) {
            if(node.hasParent()){
                if(node.isRed() && node.parent.isRed()){
                    fail("Красная нода имеет красного родителя, значение: %d, входные данные: %s".formatted(node.value, Arrays.toString(binarySearchTreeAndData.data)));
                }
            }
        }
    }
    @Test void headIsBlack(){
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(defaultDataSize);
        assertTrue(binarySearchTreeAndData.tree.getHead().isBlack(), "Корень оказался красным, входные данные: %s".formatted(Arrays.toString(binarySearchTreeAndData.data)));
    }
    @Test void allBlackDepthAreEqual(){
        //ищем ноды у которых либо нет детей, либо есть только один ребёнок
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(defaultDataSize);
        Collection<TreeNode> endPoints = StreamSupport.stream(binarySearchTreeAndData.tree.spliterator(), false)
                .filter((n)-> n.left == null || n.right == null).toList();
        //теперь задача пройти от каждой до корня, и подсчитать количество чёрных вершин встреченных на пути
        Collection<Integer> counts = new LinkedList<>();
        for (TreeNode endPoint : endPoints){
            TreeNode currentNode = endPoint;
            int countBlacks = 0;
            while (currentNode.hasParent()){
                if(currentNode.isBlack())countBlacks++;
                currentNode = currentNode.parent;
            }
            counts.add(countBlacks);
        }
        Set<Integer> uniqueCounts = new HashSet<>(counts);
        assertEquals(1, uniqueCounts.size(), "Количество чёрных вершин от конечных точек до корня разные! Количества: %s\n\n Входные данные: %s".formatted(Arrays.toString(binarySearchTreeAndData.data), uniqueCounts));
    }
    @Test void redNodesAreOnlyLeftChildren(){
        // TODO: 04.06.2023 написать этот тест
        BinarySearchTreeAndData binarySearchTreeAndData = generateRandomFilledTree(defaultDataSize);
        var redChildren = StreamSupport.stream(binarySearchTreeAndData.tree.spliterator(), false).filter(n->n.hasParent() && n.isRed()).toList();
        for (var childNode : redChildren) {
            if(childNode.isRight()){
                fail("Есть правая красная нода в красно-чёрном дереве");
            }
        }
    }
}
