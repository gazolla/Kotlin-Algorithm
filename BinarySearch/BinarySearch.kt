/**
 * Created by gazollajunior on 03/04/16.
 */

fun <T:Comparable<T>>binarySearch(list:List<T>, key:T):Int?{
    var rangeStart = 0
    var rangeEnd = list.count()
    while (rangeStart < rangeEnd) {
        val midIndex = rangeStart + (rangeEnd - rangeStart)/2
        if (list[midIndex] == key) {
            return midIndex
        } else if (list[midIndex] < key){
            rangeStart = midIndex + 1
        } else {
            rangeEnd = midIndex
        }
    }
    return null
}


fun main(args: Array<String>) {
    println("\nOrdered list:")
    val ordered = listOf<String>("Adam", "Clark", "John", "Tim", "Zack")
    println(ordered)
    val name = "John"
    val position = binarySearch(ordered, name)
    println("\n${name} is in the position ${position} in the ordered List.")
}