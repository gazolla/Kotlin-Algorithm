import java.util.*

/**
 * Created by gazollajunior on 03/04/16.
 */

fun <T: Comparable<T>> binarySearch(list: List<T>, key: T): Int? {
    var rangeStart = 0
    var rangeEnd = list.count()
    while (rangeStart < rangeEnd) {
        val midIndex = rangeStart + (rangeEnd - rangeStart)/2
        if (list[midIndex] == key) {
            return midIndex
        } else if (list[midIndex] < key) {
            rangeStart = midIndex + 1
        } else {
            rangeEnd = midIndex
        }
    }
    return null
}

fun <T: Comparable<T>> binarySearchRec(list: List<T>, key: T): Optional<Int> {
    require(list == list.sorted())

    fun helper(start: Int, end: Int): Optional<Int> {
        val mid: Int = start + (end - start) / 2
        if (end < start) return Optional.empty()

        if (key == list[mid]) {
            return Optional.of(mid)
        } else if (key < list[mid]) {
            return helper(start, mid - 1)
        } else {
            return helper(mid + 1, end)
        }
    }

    return helper(0, list.count())
}

fun main(args: Array<String>) {
    println("\nOrdered list:")
    val ordered = listOf("Adam", "Clark", "John", "Tim", "Zack")
    println(ordered)
    val name = "John"
    println("\n$name is in the position ${binarySearch(ordered, name)} in the ordered List.")
    println("\n$name is in the position ${binarySearchRec(ordered, name)} in the ordered List.")
}
