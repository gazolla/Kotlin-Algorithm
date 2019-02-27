fun <T: Comparable<T>> QuickSearch(lst: List<T>,k: Int): T {
    // k is from 0..lst.size-1
    // returns kth index in sorted list from the List provided
    if (lst.size==1) return lst[0]
    val pivot = lst[lst.count()/2]
    val less = lst.filter { it < pivot }
    val equal = lst.filter { it == pivot }
    val greater = lst.filter { it > pivot }
    /* println(pivot)
    println("$less --> ${less.size}")
    println("$equal --> ${equal.size}")
    println("$greater --> ${greater.size}") */
    when {
        k <= less.size-1 -> return QuickSearch(less,k)
        k <= (less.size + equal.size-1)  -> {
            return equal[0]
        }
        else -> {
            return QuickSearch(greater,k-less.size-equal.size)
        }
    }
}

fun main () {
    /* val lst: List<Int> = listOf(6,5,4,3,2,1) */
    val lst: List<Int> = listOf(1,2,3,4,5,6)
    for (i in 0..lst.size-1)
        println("%d --------------------> %d".format(i,QuickSearch(lst,i)))
}
