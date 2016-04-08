# Ordered Set

An ordered set is a common data structure that supports O(log N) lookups, insertions and removals. Ordered set is also sometimes used as an alternative to a hash map, for example in STL’s map.

The implementation is quite basic:

```kotlin
class OrderedSet<T:Comparable<T>>(list:MutableList<T>){

    var items: MutableList<T>  = list

     fun insert(element:T) {
        if (exists(element)) {
           return
        }
        for (i in 0..this.items.count() - 1){
            if (this.items[i] > element){
                this.items.add(i, element)
                return
            }
        }
         this.items.add(element)
    }

    /**
     * Use binarySearch algorithm to find the position for the new element in array
     */

    fun findElementPosition(element:T):Int?{
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
        return null
    }

    override fun toString():String = this.items.toString()

    fun isEmpty():Boolean = this.items.isEmpty()

    fun exists(element:T):Boolean = findElementPosition(element) != null

    fun count():Int = this.items.count()

    fun remove(element:T) {
        val position = findElementPosition(element)
        if (position != null) {
            this.items.removeAt(position)
        }
    }

    fun removeAll() =  this.items.removeAll(this.items)

    fun max():T? {
        if (count() != 0) {
            return this.items[count() - 1]
        } else {
            return null
        }
    }
    fun min():T? {
        if (count() != 0) {
            return this.items[0]
        } else {
            return null
        }
    }
}

```