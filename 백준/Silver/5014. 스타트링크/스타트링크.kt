import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (f, s, g, u, d) = br.readLine().split(" ").map { it.toInt() }

    val q: Queue<Pair<Int, Int>> = LinkedList()

    val dp = IntArray(f + 1) { Int.MAX_VALUE }
    q.add(Pair(s, 0))
    dp[s] = 0

    while (q.isNotEmpty()) {
        val (dest, c) = q.poll()
        if (c >= dp[g] || dp[dest] < c) continue

        val up = dest + u
        val down = dest - d
        val newC = c + 1

        if (u > 0 && up in dp.indices && dp[up] > newC) {
            dp[up] = newC
            q.add(Pair(up, newC))
        }
        if (d > 0 && down in 1 until dp.size && dp[down] > newC) {
            dp[down] = newC
            q.add(Pair(down, newC))
        }
    }

    println(if (dp[g] == Int.MAX_VALUE) "use the stairs" else dp[g])
}

