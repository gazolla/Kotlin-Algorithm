# Binary Search

Binary Search is a search algorithm that finds the position of a target value, whether alone or part of a record, within a sorted array. It works by comparing the target value to the middle element of the array; if they are not equal, the lower or upper half of the array is eliminated depending on the result and the search is repeated until the position of the target value is found.

## The code

Here is a recursive implementation of binary search in kotlin:

```kotlin
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
```
