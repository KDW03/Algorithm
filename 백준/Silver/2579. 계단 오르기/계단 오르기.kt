import kotlin.math.max

lateinit var dp: Array<Array<Int>>
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    // 1칸 이동 2칸 이동 값 담기
    val arr = IntArray(n + 1)
    dp = Array(n + 1) { Array(2) { -1 } }
    for (i in 1 until n + 1) {
        arr[i] = br.readLine().toInt()
    }
    println(d(arr, n, 0) + arr[n])
}

fun d(arr: IntArray, n: Int, count: Int): Int {
    if (n <= 1) return 0
    if (dp[n][count] == -1) {
        dp[n][count] = if (count == 1) d(arr, n - 2, 0) + arr[n - 2]
        else max(d(arr, n - 1, 1) + arr[n - 1], d(arr, n - 2, 0) + arr[n - 2])
    }
    return dp[n][count]
}
