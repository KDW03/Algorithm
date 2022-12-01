import java.math.BigInteger
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    if (n == 0 || n == 1) {
        print(n)
    } else {
        val dp = arrayOfNulls<BigInteger>(n + 1)
        dp[0] = BigInteger.ZERO
        dp[1] = BigInteger.ONE
        for (i in 2..n) {
            dp[i] = dp[i - 2]?.add(dp[i - 1])
        }
        print(dp[n].toString())
    }
}
