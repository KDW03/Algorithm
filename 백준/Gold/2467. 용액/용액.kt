import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }.sortedBy {
        abs(it)
    }
    var min = Int.MAX_VALUE
    var minA = -1
    var minB = -1
    for (i in 0 until nums.size - 1) {
        val new = abs(nums[i] + nums[i + 1])
        if (new < min) {
            min = new
            minA = nums[i]
            minB = nums[i + 1]
        }
    }

    println(arrayOf(minA,minB).sorted().joinToString(" "))
}