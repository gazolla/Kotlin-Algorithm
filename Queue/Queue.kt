/**
 * Created by gazollajunior on 05/04/16.
 */
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


fun main(args: Array<String>) {

    var initialValue =  mutableListOf<Int>(10)
    var queue = Queue<Int>(initialValue)
    println(queue)
    queue.enqueue(22)
    println(queue)
    queue.enqueue(55)
    println(queue)
    queue.enqueue(77)
    println(queue)
    queue.dequeue()
    println(queue)
    queue.dequeue()
    println(queue)
    queue.dequeue()
    println(queue)


}