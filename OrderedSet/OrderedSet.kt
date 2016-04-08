/**
 * Created by gazollajunior on 08/04/16.
 */

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



fun main(args: Array<String>) {


    println("\nOriginal set:")
    val names =  mutableListOf<String>("Demetrius")

    var nameSet = OrderedSet<String>(names)
    println(nameSet)


    val n1 = "Adam"
    println("\nAdding ${n1} to the list:")
    nameSet.insert(n1)
    println(nameSet)

    val n2 = "Tim"
    println("\nAdding ${n2} to the list:")
    nameSet.insert(n2)
    println(nameSet)

    val n3 = "Zack"
    println("\nAdding ${n3} to the list:")
    nameSet.insert(n3)
    println(nameSet)

    val n4 = "Zack"
    println("\nTry Add ${n4} again to the list:")
    nameSet.insert(n4)
    println(nameSet)
	
	nameSet.remove(n2)
	println("\nRemoving ${n2} from the list:")
	println(nameSet)

	nameSet.remove(n4)
	println("\nRemoving ${n4} from the list:")
	println(nameSet)

	nameSet.remove(n1)
	println("\nRemoving ${n1} from the list:")
	println(nameSet)

}