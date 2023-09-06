import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val sb = StringBuilder()
    // 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값

    // n에서 i 만큼 빼준거 즉 1만 뺀 경우 수 합
    val dp = Array(n + 1) { Pair(0, 0) }

    // i의 수를 만드는 최소수
    for (i in 2..n) {
        val list = mutableListOf<Pair<Int, Int>>()
        //i - 1에다가 1을 더해줬을때
        if (i >= 3 && i % 3 == 0) list.add(Pair(dp[i / 3].first + 1, i / 3))
        if (i % 2 == 0) list.add(Pair(dp[i / 2].first + 1, i / 2))
        list.add(Pair(dp[i - 1].first + 1, i - 1))
        dp[i] = list.minBy { it.first }
    }


    println(dp[n].first)
    var t = n
    // 1이 아닐때 까지 계속
    while (t != 1) {
        sb.append("$t ")
        t = dp[t].second
    }
    println(sb.append(t).toString())
}