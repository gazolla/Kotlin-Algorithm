package heap

class MaxHeap<T: Comparable<T>> {
    val heap = ArrayList<T>()
    var isMinHeap = true

    fun getRootIndex(i: Int): Int? {
        if(i == 0) return null
        return (i - 1) / 2
    }

    fun getLeftChildIndex(i: Int): Int? {
        val left = 2 * i + 1
        return if (left < heap.size) left else null
    }

    fun getRightChildIndex(i: Int): Int? {
        val right = 2 * i + 2
        return if (right < heap.size) right else null
    }

    fun insert(element: T) {
        heap.add(element)
        var idx = heap.lastIndex
        while(idx > 0
                && getRootIndex(idx) != null
                && heap[getRootIndex(idx)!!] < heap[idx]) {
            getRootIndex(idx)?.let {
                val temp = heap[idx]
                heap[idx] = heap[it]
                heap[it] = temp
                idx = it
            }
        }
    }

    fun remove(): T {
        val result = heap[0]
        heap[0] = heap[heap.lastIndex]
        heap.removeAt(heap.lastIndex)
        
        var here = 0
        loop@while(true) {
                
            val left = getLeftChildIndex(here)
            val right = getRightChildIndex(here)
            if(left == null) break@loop
                
            var next = here
            if(heap[next] < heap[left] 
            	&& (right == null 
            		|| heap[left] > heap[right])) {
                next = left 
            } else if(right != null 
                    && heap[next] < heap[right]) {
                next = right
            }
            if(next == here) break@loop
                
            val temp = heap[here]
            heap[here] = heap[next]
            heap[next] = temp
            
            here = next
        }
            
        return result
    }

    fun sort(): ArrayList<T> {
        val result = ArrayList<T>()
        val copy = ArrayList<T>()
        copy.addAll(heap)
            
        while(heap.size > 0) {
            result.add(remove())
        }
        
        heap.addAll(copy)
        return result
    }

    fun print() {
        heap.forEach { 
            print("${it.toString()} ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    println("Heap: ")

    val heap = MaxHeap<Int>()
    heap.insert(4)
    heap.print()
    heap.insert(2)
    heap.print()
    heap.insert(10)
    heap.print()
    heap.insert(3)
    heap.print()
    heap.insert(1)
    heap.print()
    heap.insert(5)
    heap.print()
    heap.insert(7)
    heap.print()
    heap.insert(9)
    heap.print()
    
    print("sort: ")
    heap.sort().forEach { 
        print("$it ")
    }
    println()
}