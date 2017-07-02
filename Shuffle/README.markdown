# Shuffle

Randomly rearranges the contents of an array.

## The code

Here is a implementation of Shuffle in kotlin:

```kotlin
fun <T:Comparable<T>>shuffle(items:MutableList<T>):List<T>{
    val rg : Random = Random()
    for (i in 0..items.size - 1) {
        val randomPosition = rg.nextInt(items.size)
        val tmp : T = items[i]
        items[i] = items[randomPosition]
        items[randomPosition] = tmp
    }
    return items
}
```

Shuffle implementation provide by Markus Kramer. This implementation reuses existing code to do the shuffling and can be called like other kotlin collection functions.
 
```kotlin
  /**
     * Returns a randomized list.
     */
    fun <T> Iterable<T>.shuffle(seed: Long? = null): List<T> {
        val list = this.toMutableList()
        val random = if (seed != null) Random(seed) else Random()
        Collections.shuffle(list, random)
        return list
    }
```
