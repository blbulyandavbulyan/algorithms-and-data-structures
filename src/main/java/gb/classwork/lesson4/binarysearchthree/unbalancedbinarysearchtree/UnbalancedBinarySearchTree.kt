package gb.classwork.lesson4.binarysearchthree

import gb.classwork.lesson2.lection.randomArrayGenerator
import gb.classwork.lesson4.keynode.KeyNode

class UnbalancedBinarySearchTree<K : Comparable<K>> : AbstractUnbalancedBinarySearchTree<K, KeyNode<K>>({key->KeyNode(key)}) {
}
