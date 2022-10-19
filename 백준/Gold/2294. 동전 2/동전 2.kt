import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(' ').map { it.toInt() }

    val coins  : HashSet<Int> = HashSet()
    val dp = IntArray(k + 1){10001}

    //각 화폐로만 구성되는 dp 테이블 작성
    for(i in 0 until n){
        val coin = br.readLine().toInt()
        coins.add(coin)
        var count = 1
        while (true){
            val idx = coin * count
            if (idx > k) break
            dp[idx] = count++
        }
    }

    //화폐돌면서 해당 화폐를 섞었을 때 와 섞지 않을 때 최소를 비교해서 dp 작성
    for (coin in coins){
        for (j in coin .. k)
            dp[j] = min(dp[j],dp[j-coin] + 1)
    }

    dp[k].let {
        if (it == 10001) println(-1)
        else println(it)
    }

}
