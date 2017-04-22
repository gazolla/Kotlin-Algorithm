fun main(args: Array<String>) {

    val adjacencyList = AdjacencyList<String>()

    val s = adjacencyList.createVertex("S")
    val a = adjacencyList.createVertex("A")
    val b = adjacencyList.createVertex("B")
    val c = adjacencyList.createVertex("C")
    val d = adjacencyList.createVertex("D")
    val f = adjacencyList.createVertex("F")
    val g = adjacencyList.createVertex("G")
    val e = adjacencyList.createVertex("E")

    adjacencyList.add(Undirected(), s, a)
    adjacencyList.add(Undirected(), a, b)
    adjacencyList.add(Undirected(), a, d)
    adjacencyList.add(Undirected(), a, c)
    adjacencyList.add(Undirected(), b, d)
    adjacencyList.add(Undirected(), d, g)
    adjacencyList.add(Undirected(), d, f)
    adjacencyList.add(Undirected(), f, e)

    print(adjacencyList)
    print(depthFirstSearch(s, e, adjacencyList))

}

fun depthFirstSearch(start: VertexString, end: VertexString, graph: AdjacencyList<String>): Stack<VertexString> {
    val visited: MutableSet<VertexString> = mutableSetOf()
    val stack = Stack<VertexString>()

    stack.push(start)
    visited.add(start)

    var vertex = stack.peek()

    loop@while (vertex != null && vertex != end) {

        val neighbors = graph.edges(vertex)
        if (neighbors != null && neighbors.count() > 0) {

            for (edge in neighbors) {
                if (!visited.contains(edge.destination)) {
                    visited.add(edge.destination)
                    stack.push(edge.destination)
                    print("$stack")
                    vertex = stack.peek()
                    continue@loop
                }
            }

        } else {
            print("backtrack from $vertex")
            stack.pop()
            vertex = stack.peek()
            continue
        }

        print("backtrack from $vertex")
        stack.pop()
        vertex = stack.peek()
    }

    return stack
}