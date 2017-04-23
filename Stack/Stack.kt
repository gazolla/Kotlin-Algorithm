/**
 * Created by gazollajunior on 03/04/16.
 */


class Stack<T:Comparable<T>>(list:MutableList<T>) {

    var items: MutableList<T> = list


    fun isEmpty():Boolean = this.items.isEmpty()

    fun count():Int = this.items.count()

    fun push(element:T) {
        val position = this.count()
        this.items.add(position, element)
    }

    override  fun toString() = this.items.toString()

    fun pop():T? {
        if (this.isEmpty()) {
            return null
        } else {
            val item =  this.items.count() - 1
            return this.items.removeAt(item)
        }
    }

    fun peek():T? {
        if (isEmpty()) {
            return null
        } else {
            return this.items[this.items.count() - 1]
        }
    }

    override fun toString(): String {
        val topDivider = "---Stack---\n"
        val bottomDivider = "\n-----------"

        val stackElements = array.map {
            "$it"
        }.reversed().joinToString("\n")

        return topDivider + stackElements + bottomDivider

    }

}

fun main(args: Array<String>) {

    var initialValue =  mutableListOf<Int>(10)
    var stack = Stack<Int>(initialValue)
    println(stack)
    stack.push(22)
    println(stack)
    stack.push(55)
    println(stack)
    stack.push(77)
    println(stack)
    stack.pop()
    println(stack)


}