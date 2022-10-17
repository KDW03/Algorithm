fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n+1)
    for (i in 2 .. n){
        var two : Int = Int.MAX_VALUE
        var three : Int = Int.MAX_VALUE
        if (i % 3 == 0)
            three = dp[i/3]
        if (i % 2 == 0)
            two = dp[i/2]
        val one = dp[i-1]
        dp[i] = minOf(one,two,three) + 1
    }
    println(dp[n])
}