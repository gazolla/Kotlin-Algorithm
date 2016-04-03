# Quicksort

Goal: Sort an array from low to high (or high to low).

Quicksort is one of the most famous algorithms in history. It was invented way back in 1959 by Tony Hoare, at a time when recursion was still a fairly nebulous concept.

Here's an implementation in Swift that should be easy to understand:

```kotlin
fun <T:Comparable<T>>quicksort(items:List<T>):List<T>{
    if (items.count() < 1) return items
    val pivot = items[items.count()/2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quicksort(less) + equal + quicksort(greater)
}
```