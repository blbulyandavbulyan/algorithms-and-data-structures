package gb.classwork.lesson4.binarysearchthree

import gb.classwork.lesson4.AbstractStorage
import gb.classwork.lesson4.keynode.KeyValueNode

//
//import gb.classwork.lesson4.AbstractStorage
//import gb.classwork.lesson4.KeyNode
//import gb.classwork.lesson4.TreeNode
//import gb.classwork.lesson4.binarysearchthree.exceptions.KeyAlreadyAddedException
//import gb.classwork.lesson4.binarysearchthree.exceptions.KeyNotFoundException
//import gb.classwork.lesson4.binarysearchthree.exceptions.UnexpectedException
///**
// * Данный класс предоставляет реализацию двоичного дерева поиска без балансировки
// * @author David Blbulyan
// * */
class BinaryTreeMap<K:Comparable<K>, V> : AbstractUnbalancedBinarySearchTree<K, KeyValueNode<K, V>>({ key->KeyValueNode(key, null)}), AbstractStorage<K,V>{
    override fun findValue(key: K): V? {
        return find(key).value
    }

    override fun addValue(key: K, value: V?) {
        add(key).value = value
    }

    override fun getAndRemove(key: K): V? {
        return remove(key).value
    }

}