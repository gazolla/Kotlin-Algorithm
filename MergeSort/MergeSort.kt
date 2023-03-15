/**
 * Created by gazollajunior on 09/04/16.
 * Updated by yazdanmanesh on 03/16/23
 */
fun <T : Comparable<T>> mergeSort(items: List<T>): List<T> {
    if (items.size <= 1) {
        return items
    }

    fun merge(left: List<T>, right: List<T>): List<T> {
        val merged = mutableListOf<T>()
        var leftIndex = 0
        var rightIndex = 0

        while (leftIndex < left.size && rightIndex < right.size) {
            if (left[leftIndex] < right[rightIndex]) {
                merged.add(left[leftIndex])
                leftIndex++
            } else {
                merged.add(right[rightIndex])
                rightIndex++
            }
        }

        // Add the remaining elements from the unfinished list
        merged.addAll(left.subList(leftIndex, left.size))
        merged.addAll(right.subList(rightIndex, right.size))

        return merged
    }

    val pivot = items.size / 2
    val left = mergeSort(items.subList(0, pivot))
    val right = mergeSort(items.subList(pivot, items.size))

    return merge(left, right)
}

fun main() {
    val names = mutableListOf("John", "Tim", "Zack", "Daniel", "Adam")
    println(names)
    val ordered = mergeSort(names)
    println(ordered)
}