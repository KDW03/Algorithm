fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val nums = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n) { 1 }

    for (i in nums.indices) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }

    println(dp.max())
}