package gb.classwork.lesson4.binarysearchthree

import gb.classwork.lesson4.AbstractStorage
import gb.classwork.lesson4.TreeNode
import gb.classwork.lesson4.binarysearchthree.exceptions.KeyAlreadyAddedException
import gb.classwork.lesson4.binarysearchthree.exceptions.KeyNotFoundException
import gb.classwork.lesson4.binarysearchthree.exceptions.UnexpectedException

class BinarySearchTree<K: Comparable<K>, V>: AbstractStorage<K, V> {
    private var size: Int = 0
    private var root: TreeNode<K, V>? = null;

    override fun find(key: K): V = findNode(key).value

    override fun add(key: K, value: V) {
        findPlaceAndInsertNode(TreeNode(key, value))
        size++;
    }

    override fun remove(key: K): V {
        val nodeForDelete = findNode(key);
        val value = nodeForDelete.value
        if(nodeForDelete.hasParent()){//если наш найденный элемент это не корень
            val parent: TreeNode<K, V> = nodeForDelete.parent ?: throw UnexpectedException("WTF, сюда не мог попасть null!")
            if(nodeForDelete.hasChild()){
                if(parent.left === nodeForDelete){
                    parent.left = nodeForDelete.left
                    val right = nodeForDelete.right
                    if(right != null)findPlaceAndInsertNode(right)
                }
                else if(parent.right === nodeForDelete){
                    parent.right = nodeForDelete.right
                    val left = nodeForDelete.left
                    if(left != null)findPlaceAndInsertNode(left)
                }
                else throw UnexpectedException("Что-то пошло не так и родительский элемент не является родительским элементом...")
            }
            else if(parent.left === nodeForDelete)parent.left = null
            else parent.right = null;
        }
        else root = null
        size--
        return value
    }
    private fun findNode(key: K): TreeNode<K, V>{
        var currentRoot = root ?: throw KeyNotFoundException()
        while (currentRoot.hasChild()){
            if(key == currentRoot.key)
                return currentRoot;
            else if(key > currentRoot.key)
                currentRoot = currentRoot.right ?: throw KeyNotFoundException();
            else if(key < currentRoot.key)
                currentRoot = currentRoot.left ?: throw KeyNotFoundException();
        }
        if(currentRoot.key != key)throw KeyNotFoundException()
        else return currentRoot;
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
            node.parent = currentNodeToInsert
            if(currentNodeToInsert.right == null && node.key > currentNodeToInsert.key)
                currentNodeToInsert.right = node
            else if (currentNodeToInsert.left == null && node.key <= currentNodeToInsert.key)
                currentNodeToInsert.left = node
            else if(node.key != currentNodeToInsert.key) throw UnexpectedException("Неожиданное исключение, ссылка в которую нужно записать оказалась не null!") //по идее это исключение не должно возникнуть, но мало ли;
        }
    }
}