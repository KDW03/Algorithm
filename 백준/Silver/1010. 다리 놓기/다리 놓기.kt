import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    //팩토리얼 테이블만들자

    val testCase = br.readLine().toInt()
    val dp = arrayOfNulls<BigInteger>(30)
    dp[0] = BigInteger("1")
    dp[1] = BigInteger("1")

    for (i in 2..29) {
        dp[i] = dp[i - 1]?.multiply(BigInteger("$i"))
    }

    repeat(testCase) {
        val tmp = br.readLine().split(" ")
        val r = tmp[0].toInt()
        val n = tmp[1].toInt()
        sb.append((dp[n]?.divide(dp[n-r]))?.divide(dp[r])).append("\n")
    }
    print(sb.toString())
}
