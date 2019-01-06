# Heap

In computer science, a heap is a specialized tree-based data structure which is essentially an almost complete[1] tree that satisfies the heap property: if P is a parent node of C, then the key (the value) of P is either greater than or equal to (in a max heap) or less than or equal to (in a min heap) the key of C.[2] The node at the "top" of the heap (with no parents) is called the root node.

The heap is one maximally efficient implementation of an abstract data type called a priority queue, and in fact priority queues are often referred to as "heaps", regardless of how they may be implemented. A common implementation of a heap is the binary heap, in which the tree is a binary tree (see figure). The heap data structure, specifically the binary heap, was introduced by J. W. J. Williams in 1964, as a data structure for the heapsort sorting algorithm.[3] Heaps are also crucial in several efficient graph algorithms such as Dijkstra's algorithm.

In a heap, the highest (or lowest) priority element is always stored at the root. A heap is not a sorted structure and can be regarded as partially ordered. When a heap is a complete binary tree, it has a smallest possible height—a heap with N nodes and for each node a branches always has loga N height. A heap is a useful data structure when you need to remove the object with the highest (or lowest) priority.

Note that, as shown in the graphic, there is no implied ordering between siblings or cousins and no implied sequence for an in-order traversal (as there would be in, e.g., a binary search tree). The heap relation mentioned above applies only between nodes and their parents, grandparents, etc. The maximum number of children each node can have depends on the type of heap, but in many types it is at most two, which is known as a binary heap.

source:Wikipedia

## The Code

```kotlin
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
```