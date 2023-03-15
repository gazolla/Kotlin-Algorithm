# MergeSort

Merge Sort is an efficient, general-purpose, comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output. Mergesort is a divide and conquer algorithm that was invented by John von Neumann in 1945.

source:Wikipedia

## The code

```kotlin
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

```