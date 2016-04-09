# Selection sort

Selection sort is a sorting algorithm, specifically an in-place comparison sort. It has O(n2) time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort. Selection sort is noted for its simplicity, and it has performance advantages over more complicated algorithms in certain situations, particularly where auxiliary memory is limited.

source:Wikipedia

## The code

```kotlin
fun <T:Comparable<T>>selectionsort(items:MutableList<T>):MutableList<T>{
    if (items.isEmpty()){
        return items
    }
    for (idx in 0..items.count()){
        val array = items.subList(0,items.count()-idx)
        val minItem = array.min()
        val indexOfMinItem = array.indexOf(minItem)

        if (minItem != null) {
            items.removeAt(indexOfMinItem)
            items.add(minItem)
        }
    }
    return items
}
```