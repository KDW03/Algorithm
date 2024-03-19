fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val nums = Array(n) { br.readLine().toInt() }

    val dp = IntArray(n) { 1 }
    for (i in 1 until n) {
        val a = nums[i]
        for (j in 0 until i) {
            val b = nums[j]
            if (a > b) dp[i] = maxOf(dp[i], dp[j] + 1)
        }
    }

    println(n - dp.maxOrNull()!!)
}