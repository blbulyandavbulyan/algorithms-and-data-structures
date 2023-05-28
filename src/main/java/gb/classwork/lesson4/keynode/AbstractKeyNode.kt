package gb.classwork.lesson4.keynode

abstract class AbstractKeyNode<K: Comparable<K>, NT: AbstractKeyNode<K, NT>>(val key: K) {
    var parent: NT? = null
    var left: NT? = null
    var right: NT? = null
    fun hasChild(): Boolean = left != null || right != null
    fun hasParent(): Boolean = parent != null

}