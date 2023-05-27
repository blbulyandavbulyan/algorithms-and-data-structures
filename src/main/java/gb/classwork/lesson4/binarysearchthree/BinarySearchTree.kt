package gb.classwork.lesson4.binarysearchthree

import gb.classwork.lesson4.AbstractStorage
import gb.classwork.lesson4.TreeNode
import gb.classwork.lesson4.binarysearchthree.exceptions.KeyAlreadyAddedException
import gb.classwork.lesson4.binarysearchthree.exceptions.KeyNotFoundException
import gb.classwork.lesson4.binarysearchthree.exceptions.UnexpectedException
/**
 * Данный класс предоставляет реализацию двоичного дерева поиска без балансировки
 * @author David Blbulyan
 * */
class BinarySearchTree<K: Comparable<K>, V>: AbstractStorage<K, V> {
    private var size: Int = 0
    private var root: TreeNode<K, V>? = null;

    override fun find(key: K): V = findNode(key).value

    override fun add(key: K, value: V) {
        findPlaceAndInsertNode(TreeNode(key, value))
        size++;
    }

    override fun remove(key: K): V {
        // FIXME: Исправить эту функцию, при удалении почему-то удаляется то, что не должно было удалится
        // FIXME: Здесь ещё внезапно может вылететь исключение KeyAlreadyAddedException проверить почему !!!
        val nodeForDelete = findNode(key);//ищем удаляемую ноду
        val value = nodeForDelete.value
        if(nodeForDelete.hasParent()){//если наш найденный элемент это не корень
            val parent: TreeNode<K, V> = nodeForDelete.parent ?: throw UnexpectedException("WTF, сюда не мог попасть null!")
            if(parent.left === nodeForDelete){
                //у нас удаляемый элемент левый в parent, значит он меньше чем parent, а значит правый элемент в удаляемом элементе тоже будет меньше чем parent
                parent.left = nodeForDelete.left
                parent.left?.parent = parent//установка нового родителя
                val right = nodeForDelete.right
                if(right != null)findPlaceAndInsertNode(right)//если правый элемент у удаляемого был, добавляем его
            }
            else if(parent.right === nodeForDelete){
                //у нас удаляемый элемент правый в parent, значит он больше parent, значит правый элемент удаляемого элемента тоже будет больше parent
                parent.right = nodeForDelete.right
                parent.right?.parent = parent//установка нового родителя
                val left = nodeForDelete.left
                if(left != null)findPlaceAndInsertNode(left)//если левый элемент у удаляемого был, добавляем его
            }
            else throw UnexpectedException("Что-то пошло не так и родительский элемент не является родительским элементом...")
        }
        else {
            //здесь вероятно нужно более детально выбирать какой ребёнок теперь станет корневым
            val newRoot: TreeNode<K, V>? = (root?.right ?: root?.left) //выбираем правого если он не null, иначе выбираем левого
            val futureChild: TreeNode<K, V>? = (root?.left ?: root?.right)//а здесь наоборот, выбираем левого если он не null, иначе правого
            newRoot?.parent = null;
            root = newRoot//если новый корень null, значит у него не было потомков
            if(newRoot != null){//бум, мы точно знаем что у старого корня были дети
                if(newRoot !== futureChild && futureChild != null)
                    findPlaceAndInsertNode(futureChild)
            }
        }
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