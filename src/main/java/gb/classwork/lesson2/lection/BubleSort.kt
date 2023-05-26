package gb.classwork.lesson2.lection

import kotlin.random.Random
import kotlin.system.exitProcess

fun <T: Comparable<T>> bubbleSort(arr: Array<T> ){
    for(i in arr.lastIndex downTo 1){
        for (j in 0 until i){
            if(arr[j] > arr[j+1]){
                arr[j] = arr[j+1].also { arr[j+1] = arr[j] }
            }
        }
    }
}
fun directSort(arr: IntArray){
    for (currentMinimalPosition in arr.indices){
        var actualMinimalPosition = currentMinimalPosition
        for(i in currentMinimalPosition+1..arr.lastIndex){
            if(arr[i] < arr[actualMinimalPosition]){
                actualMinimalPosition = i
            }
        }
        if(arr[actualMinimalPosition] < arr[currentMinimalPosition]){
            val temp = arr[actualMinimalPosition]
            arr[actualMinimalPosition] = arr[currentMinimalPosition]
            arr[currentMinimalPosition] = temp
        }
    }
}
fun binarySearch(arr: IntArray, value: Int): Int{
    var beginIndex = 0
    var endIndex = arr.lastIndex
    while (beginIndex <= endIndex){
        val middle = beginIndex + (endIndex - beginIndex)/2
        if(arr[middle] == value)return middle;
        else if(value > arr[middle]){
            beginIndex = middle+1
        }
        else if(value < arr[middle]) {
            endIndex = middle - 1
        }
    }
    return -1;
}
fun randomArrayGenerator(count: Int):IntArray{
    var arr: IntArray = IntArray(count){Random.nextInt(1000)}
    return arr
}
fun main() {
    println(Int.MAX_VALUE)
    val arr = randomArrayGenerator(Int.MAX_VALUE/4)
//    arr.shuffle();
////    println(arr.contentToString())
//    for (i in arr.indices){
//        print("${arr[i]} ")
//    }
//    println()
//    directSort(arr)
    arr.sort()
//    for (i in arr.indices){
//        print("${arr[i]} ")
//    }
    println()
    for (i in arr.indices){
        val result = binarySearch(arr, arr[i])
        if(arr[result] != arr[i]){
            println("Тест провален на элементе ${arr[i]} под индексом $i, функция выдала: $result")
            exitProcess(-1)
        }
    }
    println("Тесты пройдены!")
}