import java.util.*
fun findKthLargest(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    return nums[nums.size - k]
}
fun main(args: Array<String>) {
    println(findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
}