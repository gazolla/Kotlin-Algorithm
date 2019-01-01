# Breadth-First Search

Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key'), and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.

It uses the opposite strategy as depth-first search, which instead explores the highest-depth nodes first before being forced to backtrack and expand shallower nodes.

BFS and its application in finding connected components of graphs were invented in 1945 by Konrad Zuse, in his (rejected) Ph.D. thesis on the Plankalkül programming language, but this was not published until 1972. It was reinvented in 1959 by Edward F. Moore, who used it to find the shortest path out of a maze, and later developed by C. Y. Lee into a wire routing algorithm (published 1961).

source:Wikipedia

## The Code

```kotlin
fun <T:Comparable<T>>breadthFirstSearch(start: T, edges:MutableList<Pair<T, T>>) {
    val visited = mutableListOf<T>()
    val queue = ArrayList<T>()

    queue.add(start)
    visited.add(start)

    var front: T

    loop@while(queue.isNotEmpty()) {
        front = queue[0]
        queue.removeAt(0)
        println("start vertex $front")

        for(edge in edges) {
            if(edge.first == front
                    && !visited.contains(edge.second)) {
                val next = edge.second
                queue.add(next)
                visited.add(next)
                println("next vertex enqueue $next")
            }
        }
    }
}
```