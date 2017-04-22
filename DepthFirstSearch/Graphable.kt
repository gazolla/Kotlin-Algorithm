interface Graphable<T:Comparable<T>> {

    fun createVertex(data: T): Vertex<T>
    fun add(type: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double? = 0.0)
    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
    fun edges(source: Vertex<T>): MutableList<Edge<T>>?

}