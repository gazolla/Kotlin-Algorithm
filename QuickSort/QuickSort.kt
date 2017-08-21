/**
 * Created by gazollajunior on 01/04/16.
 */

fun <T:Comparable<T>>quicksort(items:List<T>):List<T>{
    if (items.count() < 2){
        return items
    }
    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quicksort(less) + equal + quicksort(greater)
}



fun main(args: Array<String>) {

    println("\nOriginal list:")
    val names = listOf<String>("Tim", "Steve", "Zack", "Adam", "John", "Peter", "Clark")
    println(names)
    println("\nOrdered list:")
    val ordered =  quicksort(names)
    println(ordered)
}

