fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n)
    for (i in 0 until nums.size) {
        val iNum = nums[i]
        dp[i] = iNum
        for (j in i - 1 downTo 0) {
            // 증가하는 부분수열이라면 dp 계산
            val jNum = nums[j]
            if (iNum > jNum) dp[i] = maxOf(dp[i], dp[j] + iNum)
        }
    }
    println(dp.max())
}