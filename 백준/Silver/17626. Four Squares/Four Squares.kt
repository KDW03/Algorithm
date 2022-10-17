import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n+1){Int.MAX_VALUE}
    dp[0] = 0
    for (i in 1 .. n){
        for (j in 1 .. sqrt(i.toDouble()).toInt()){
            //제곱최대값을 전부 탐색하면서 최소로 구성될 수 있는거 + 1 해준다
            dp[i] = min(dp[i] ,dp[i-(j*j)] + 1)
        }
    }
    println(dp[n])
}