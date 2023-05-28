package gb.classwork.lesson4.mains

import gb.classwork.lesson2.lection.randomArrayGenerator
import gb.classwork.lesson4.binarysearchthree.UnbalancedBinarySearchTree

fun main() {
    val tree: UnbalancedBinarySearchTree<Int> = UnbalancedBinarySearchTree()
    val randomKeys = randomArrayGenerator(20).distinct()
    for (key in randomKeys){
        tree.add(key)
    }
    for(key in randomKeys.shuffled()){
        println("$key в деревен ${if(tree.exists(key)) "найден" else "не найден"}")
    }
}