package breadthfirstsearch

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

fun main(args: Array<String>) {
    println("Breath First Search: ")

    val edges = ArrayList<Pair<Char, Char>>()
    edges.add('a' to 'b')
    edges.add('a' to 'c')
    edges.add('b' to 'd')
    edges.add('b' to 'e')
    edges.add('c' to 'f')
    edges.add('c' to 'g')
    edges.add('e' to 'h')

    breadthFirstSearch('a', edges)
}

