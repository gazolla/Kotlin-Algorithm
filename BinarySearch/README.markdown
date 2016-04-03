# Binary Search

Goal: Quickly find an element in an array.

Let's say you have an array of numbers and you want to determine whether a specific number is in that array, and if so, at which index.

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
