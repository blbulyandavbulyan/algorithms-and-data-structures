package gb.homework.lesson2.heap;

public interface HeapInterface<T extends Comparable<T>> {

    T max();
    T removeMax();
    void add(T element);
    boolean isEmpty();
}
