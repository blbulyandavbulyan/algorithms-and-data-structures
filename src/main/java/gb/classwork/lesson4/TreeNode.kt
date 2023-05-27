package gb.classwork.lesson4

class TreeNode<K : Comparable<K>, V>(val key: K, val value: V) {
    var left: TreeNode<K, V>? = null
    var right: TreeNode<K, V>? = null
    fun hasChild(): Boolean = left != null || right != null
}
