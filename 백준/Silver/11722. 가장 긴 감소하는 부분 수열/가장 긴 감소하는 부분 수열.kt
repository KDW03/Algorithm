fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val nums = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n) { 1 }
    for (i in 1 until n) {
        val a = nums[i]
        for (j in i - 1 downTo 0) {
            val b = nums[j]
            if (b > a) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }
    println(dp.max())
}
