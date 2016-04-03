/**
 * Created by gazollajunior on 03/04/16.
 */

import java.util.Random

fun <T:Comparable<T>>shuffle(items:MutableList<T>):List<T>{
    val rg : Random = Random()
    for (i in 0..items.size - 1) {
        val randomPosition = rg.nextInt(items.size)
        //swap(items, i, randomPosition)
        val tmp : T = items[i]
        items[i] = items[randomPosition]
        items[randomPosition] = tmp
    }
    return items
}





fun main(args: Array<String>) {
    println("\nOrdered list:")
    val ordered = listOf<String>("Adam", "Clark", "John", "Tim", "Zack")
    println(ordered)
    println("\nshuffled list:")
    val shuffled = shuffle(ordered as MutableList<String>)
    print(shuffled)
}