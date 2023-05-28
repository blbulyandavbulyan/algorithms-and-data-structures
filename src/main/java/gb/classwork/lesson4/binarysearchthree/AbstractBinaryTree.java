package gb.classwork.lesson4.binarysearchthree;

import gb.classwork.lesson4.keynode.AbstractKeyNode;

public interface AbstractBinaryTree<K extends Comparable<K>, NT extends AbstractKeyNode<K, NT>> {
    boolean exists(K key);
    NT add(K key);
    NT remove(K key);
    NT find(K key);
}
