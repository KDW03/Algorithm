fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n)
    val nums = br.readLine().split(" ").map { it.toInt() }
    dp[0] = nums[0]

    for (i in 1 until n) {
        dp[i] = maxOf(dp[i - 1] + nums[i], nums[i])
    }

    println(dp.max())
}