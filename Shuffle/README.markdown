# Shuffle

Randomly rearranges the contents of an array.

## The code

Here is a recursive implementation of binary search in kotlin:

```kotlin
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
```
