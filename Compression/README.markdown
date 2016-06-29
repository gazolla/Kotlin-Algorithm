# Run-length encoding

In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).[1] It is also often called a head-tail linked list, though properly this refers to a specific data structure implementation 

source:Wikipedia

## The code

```kotlin
class Deque<T>(){

    var backingList : MutableList<T> = arrayListOf()

    fun addFirst(element:T){
        backingList.add(0,element)
    }

    fun getFirst():T?{
        if (backingList.isEmpty()){
            return null
        }
        val value = backingList.first()
        removeFirst()
        return value
    }

    fun removeFirst(){
        if (backingList.isNotEmpty()) backingList.removeAt(0)
    }

    fun peekFirst(): T?{
        return if (backingList.isNotEmpty()) backingList.first() else null
    }

    fun addLast(element:T){
        backingList.add(element)
    }

    fun getLast():T?{
        if (backingList.isEmpty()){
            return null
        }
        val value = backingList.last()
        removeLast()
        return value
    }

    fun removeLast(){
        if (backingList.isNotEmpty()) backingList.removeAt(backingList.size - 1)
    }

    fun peekLast():T?{
        return if (backingList.isNotEmpty()) backingList.last() else null
    }
}

```

Code by: - [Andy Bowes](https://github.com/AndyBowes)