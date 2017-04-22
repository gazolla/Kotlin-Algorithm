class AdjacencyList<T: Comparable<T>>: Graphable<T> {

    var adjacencyMap: MutableMap<Vertex<T>, MutableList<Edge<T>>> = mutableMapOf()

    private fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencyMap[source]?.add(edge)
    }

    private fun addUndirectedEdge(vertices: Pair<Vertex<T>, Vertex<T>>, weight: Double?) {
        val (source, destination) = vertices
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(data)

        adjacencyMap[vertex] ?: run {
            adjacencyMap[vertex] = mutableListOf()
        }

        return vertex
    }

    override fun add(type: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) = when(type) {
        is Directed -> {
            addDirectedEdge(source, destination, weight)
        }
        is Undirected -> {
            addUndirectedEdge(Pair(source, destination), weight)
        }
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        val edges = adjacencyMap[source]
        edges?.let {

            it.forEach { edge ->
                if (edge.destination == destination) return edge.weight
            }

        }
        return null
    }

    override fun edges(source: Vertex<T>): MutableList<Edge<T>>? = adjacencyMap[source]

    override fun toString(): String {
        var result = ""
        for ((vertex, edges) in adjacencyMap) {
            var edgeString = ""
            for ((index, edge) in edges.withIndex()) {
                if (index != edges.count() - 1) {
                    edgeString += "${edge.destination}, "
                } else {
                    edgeString += "${edge.destination}"
                }
            }
            result += "$vertex ---> [ $edgeString ] \n"
        }
        return result
    }

}