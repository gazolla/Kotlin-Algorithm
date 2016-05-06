package deque

/**
 * Implementation of the Deque functionality which provides a double ended queue.
 *
 * This implementation of Deque is backed by a MutableList
 *
 * Created by Andy Bowes on 05/05/2016.
 */
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