package gb.classwork.lesson4.binarysearchthree

import gb.classwork.lesson4.AbstractTree
import gb.classwork.lesson4.TreeNode
import gb.classwork.lesson4.binarysearchthree.exceptions.KeyAlreadyAddedException
import gb.classwork.lesson4.binarysearchthree.exceptions.KeyNotFoundException
import gb.classwork.lesson4.binarysearchthree.exceptions.UnexpectedException

class BinarySearchTree<K: Comparable<K>, V>: AbstractTree<K, V> {
    private var size: Int = 0;
    private var root: TreeNode<K, V>? = null;

    override fun find(key: K): V {
        var currentRoot = root ?: throw KeyNotFoundException()
        while (currentRoot.hasChild()){
            if(key == currentRoot.key)
                return currentRoot.value;
            else if(key > currentRoot.key)
                currentRoot = currentRoot.right ?: throw KeyNotFoundException();
            else if(key < currentRoot.key)
                currentRoot = currentRoot.left ?: throw KeyNotFoundException();
        }
        if(currentRoot.key != key)throw KeyNotFoundException()
        else return currentRoot.value;
    }

    override fun add(key: K, value: V) {
        findPlaceAndInsertNode(TreeNode(key, value))
        size++;
    }

    override fun remove(key: K) {
        var currentRoot = root ?: throw KeyNotFoundException();
        while (currentRoot.hasChild())
        TODO("Not yet implemented")
    }
    private fun findNode(key: K): TreeNode<K, V>{
        TODO("Fix this")
    }
    private fun findPlaceAndInsertNode(node: TreeNode<K, V>){
        val nnRoot: TreeNode<K, V> = root ?: node;
        if (nnRoot === node){
            root = node;
            return;
        }
        else{
            var currentNodeToInsert = nnRoot;
            while (currentNodeToInsert.left != null || currentNodeToInsert.right != null){
                currentNodeToInsert = if (node.key > currentNodeToInsert.key) currentNodeToInsert.right ?: break
                else if(node.key < currentNodeToInsert.key) currentNodeToInsert.left ?: break
                else throw KeyAlreadyAddedException()
            }
            if(currentNodeToInsert.right == null && node.key > currentNodeToInsert.key)
                currentNodeToInsert.right = node
            else if (currentNodeToInsert.left == null && node.key <= currentNodeToInsert.key)
                currentNodeToInsert.left = node
            else {
               if(node.key != currentNodeToInsert.key) throw UnexpectedException()//по идее это исключение не должно возникнуть, но мало ли
            };
        }
    }
}