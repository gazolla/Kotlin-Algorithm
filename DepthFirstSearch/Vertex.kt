data class Vertex<T:Comparable<T>>(val data: T) {
    override fun toString(): String {
        return "$data"
    }
}
