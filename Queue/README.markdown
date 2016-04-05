# Queue

Queue is a particular kind of abstract data type or collection in which the entities in the collection are kept in order and the principal (or only) operations on the collection are the addition of entities to the rear terminal position, known as enqueue, and removal of entities from the front terminal position, known as dequeue. This makes the queue a First-In-First-Out (FIFO) data structure. In a FIFO data structure, the first element added to the queue will be the first one to be removed. This is equivalent to the requirement that once a new element is added, all elements that were added before have to be removed before the new element can be removed. Often a peek or front operation is also entered, returning the value of the front element without dequeuing it. A queue is an example of a linear data structure, or more abstractly a sequential collection.

source:Wikipedia

![](https://github.com/gazolla/Kotlin-Algorithm/blob/master/Queue/Queue.png)

## The code


```kotlin
class Queue <T>(list:MutableList<T>){

    var items:MutableList<T> = list

    fun isEmpty():Boolean = this.items.isEmpty()

    fun count():Int = this.items.count()

    override  fun toString() = this.items.toString()

    fun enqueue(element: T){
        this.items.add(element)
    }

    fun dequeue():T?{
        if (this.isEmpty()){
            return null
        } else {
            return this.items.removeAt(0)
        }
    }

    fun peek():T?{
        return this.items[0]
    }

}

```
