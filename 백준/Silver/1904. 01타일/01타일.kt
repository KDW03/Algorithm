fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n+2){1}
    dp[2] = 2
    for (i in 3 .. n){
        dp[i] = (dp[i-1] + dp[i-2]) % 15746
    }
    println(dp[n])
}