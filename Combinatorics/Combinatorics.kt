/**
 * Created by gazollajunior on 06/04/16.
 */

fun factorial(number:Long):Long{
    if (number <= 1) return 1  else return factorial(number - 1) * number
}

fun permutations(n:Long, k:Long):Long{
    return factorial(n)/factorial(n-k)
}

fun combinations(n:Long, k:Long):Long{
    return permutations(n,k)/factorial(k)
}


fun main(args: Array<String>) {
    println("0 factorial is ${factorial(0)}")
    println("1 factorial is ${factorial(1)}")
    println("2 factorial is ${factorial(2)}")
    println("3 factorial is ${factorial(3)}")
    println("4 factorial is ${factorial(4)}")
    println("5 factorial is ${factorial(5)}\n")

    println("permutations(9,4) ${permutations(9,4)}")
    println("permutations(10,8) ${permutations(10,8)}")
    println("permutations(20,6) ${permutations(20,6)}")
    println("permutations(22,6) ${permutations(22,6)}\n")

    println("combinations(9,4) ${combinations(9,4)}")
    println("combinations(10,8) ${combinations(10,8)}")
    println("combinations(20,6) ${combinations(20,6)}")
    println("combinations(22,6) ${combinations(22,6)}\n")

}