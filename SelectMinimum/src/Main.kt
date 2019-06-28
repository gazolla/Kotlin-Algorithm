fun main(args : Array<String>) {
    if (args.isEmpty()) print(searchMin(listOf(3, 5, 1)))
    //var list = listOf(3, 5, 1)
    if (args.isNotEmpty()) print(searchMin(args.toList()))
}

fun <T: Comparable<T>> searchMin( list: List<T> ): T? {
    if (list.size==1) return list[0]
    if (list.isEmpty()) return null
    var min = list[0]
    for (item in list){
        if (item < min) min=item
    }

    return min
}