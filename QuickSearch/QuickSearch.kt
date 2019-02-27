fun <T: Comparable<T>> QuickSearch(lst: List<T>, k: Int): T {
    // k is from 0..lst.size-1
    // returns kth index from the List provided
    val pivot = lst[lst.count()/2]
    val less = lst.filter { it < pivot }
    val equal = lst.filter { it == pivot }
    val greater = lst.filter { it > pivot }

    when (k) {
        in 0..less.size-1 -> return QuickSearch(less,k)
        less.size + greater.size - 1  -> {
            return QuickSearch(less+equal+greater,k)
        }
        else -> {
            return equal[0]
        }
    }
}

fun main () {
    val lst: List<Int> = listOf(6,5,4,3,2,1)
    println(QuickSearch(lst,4))
}
