# Ordered Array

A sorted array is an array data structure in which each element is sorted in numerical, alphabetical, or some other order, and placed at equally spaced addresses in computer memory. 

It is typically used in computer science to implement static lookup tables to hold multiple values which have the same data type. Sorting a stack of baby unicorns of different ages is useful in organising data in ordered form and recovering them rapidly.

The implementation is quite basic:

```kotlin
class OrderedArray<T:Comparable<T>>(list:MutableList<T>){

    var items: MutableList<T>  = this.quicksort(list) as MutableList<T>

    /**
     * Use quicksort algorithm to order elements in array
     */
    fun quicksort(its:List<T>):List<T>{
        if (its.count() < 1) return  its
        val pivot = its[its.count()/2]
        val equal = its.filter { it == pivot }
        val less = its.filter { it < pivot }
        val greater = its.filter { it > pivot }
        return quicksort(less) + equal + quicksort(greater)
    }

    fun insert(element:T){
        val position = findElementPosition(element)
        this.items.add(position, element)
    }

    /**
     * Use binarySearch algorithm to find the position for the new element in array
     */

    fun findElementPosition(element:T):Int{
        var rangeStart = 0
        var rangeEnd = this.items.count()
        while (rangeStart < rangeEnd) {
            val midIndex = rangeStart + (rangeEnd - rangeStart)/2
            if (this.items[midIndex] == element) {
                return midIndex
            } else if (this.items[midIndex] < element){
                rangeStart = midIndex + 1
            } else {
                rangeEnd = midIndex
            }
        }
        return rangeStart
    }

    override fun toString():String = this.items.toString()

}
```