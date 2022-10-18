fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(' ').map { it.toInt() }

    val arr = IntArray(n)
    val dp = IntArray(k + 1)

    for (i in 0 until n)
        arr[i] = br.readLine().toInt()
    dp[0] = 1
    for (i in arr){
        for (j in i .. k){
            dp[j] += dp[j-i]
        }
    }
    println(dp[k])
}