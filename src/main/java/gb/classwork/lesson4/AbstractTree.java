package gb.classwork.lesson4;

public interface AbstractTree<K extends Comparable<K>, V> {
    V find(K key);
    void add(K key, V value);
    void remove(K key);

}
