import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    println(makeCombi(nums))
}


fun makeCombi(nums: List<Int>, now: IntArray = intArrayOf(), visited: BooleanArray = BooleanArray(nums.size)): Int {
    if (now.size == nums.size) {
        return now.toList().zipWithNext { a, b -> abs(a - b) }.sum()
    }
    var max = Int.MIN_VALUE
    for (i in nums.indices) {
        if (!visited[i]) {
            visited[i] = true
            max = maxOf(max, makeCombi(nums, now + nums[i], visited))
            visited[i] = false
        }
    }
    return max
}