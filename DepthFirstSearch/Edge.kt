sealed class EdgeType

class Directed() : EdgeType()
class Undirected(): EdgeType()

data class Edge<T:Comparable<T>>(var source: Vertex<T>, var destination: Vertex<T>, val weight: Double?)