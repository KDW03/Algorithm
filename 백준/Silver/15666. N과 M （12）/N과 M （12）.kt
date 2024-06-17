fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.toSet().sorted()
    find(nums, 0, arrayOf(), m)
}

fun find(nums: List<Int>, idx: Int, now: Array<Int>, m: Int) {

    if (now.size == m) {
        println(now.joinToString(" "))
        return
    }

    for (i in idx until nums.size) find(nums, i, now + nums[i], m)
}