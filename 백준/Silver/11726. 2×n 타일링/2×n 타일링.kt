fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(1001)
    dp[1] = 1; dp[2] = 2
    for (i in 3 .. n){
        // 2x1을 추가한 경우의 수 + 1x2 2개를 추가한 경우의수
        dp[i] = (dp[i-1] + dp[i-2])%10007
    }
    println(dp[n]%10007)
}