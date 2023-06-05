package gb.classwork.lesson4.binarysearchtree;

import java.util.stream.IntStream;

public class BinarySearchTreeWithSequentialDataTest extends BinarySearchTreeTest{
    @Override
    protected int[] generateData(int count) {
        return IntStream.rangeClosed(0, count).toArray();
    }
}
