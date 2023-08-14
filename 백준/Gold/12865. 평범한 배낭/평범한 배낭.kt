import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp: Array<IntArray> = Array(n + 1) { IntArray(k + 1) }

    for (i in 1 .. n){
        val (w,v) = br.readLine().split(" ").map { it.toInt() }

        for (j in 1 .. k) {
            // 만약 현재 상품의 크기가 현재 담을 수 있는것보다 크다면
            dp[i][j] = if (j < w) {
                dp[i - 1][j]
            }else{
                // 이전 상품까지 고려했을 때가 더 큰지 현재 상품 까지 고려했을 때가 더 큰지
                max(dp[i - 1][j], dp[i - 1][j - w] + v)
            }
        }
    }

    println(dp[n][k])
}