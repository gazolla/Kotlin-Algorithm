# Linear Search

Linear search is the simplest search algorithm; it is a special case of brute-force search. Its worst case cost is proportional to the number of elements in the list. Its expected cost is also proportional to the number of elements if all elements are searched equally. If the list has more than a few elements and is searched often, then more complicated search methods such as binary search or hashing may be appropriate. Those methods have faster search times but require additional resources to attain that speed.

source:Wikipedia

## The code

```kotlin
fun <T:Comparable<T>>linearSearch(list:List<T>, key:T):Int?{
    for ((index, value) in list.withIndex()) {
        if (value == key) return index
    }
    return null
}
```
