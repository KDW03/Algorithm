import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val visited = IntArray(100001) { Int.MAX_VALUE }
    q.add(Pair(n, 0))
    var maxCount = 0
    var minCost = Int.MAX_VALUE

    while (q.isNotEmpty()) {
        val (p, cost) = q.poll()

        if (p == m) {
            if (minCost > cost) {
                maxCount = 1
                minCost = cost
            } else if (minCost == cost) {
                maxCount++
            }
            continue
        }

        if (p in 0..100000) {
            if (cost <= visited[p]) {
                visited[p] = cost
                q.add(Pair(p - 1, cost + 1))
                q.add(Pair(p + 1, cost + 1))
                if (p * 2 <= 100000) q.add(Pair(p * 2, cost + 1))
            }
        }
    }

    println(minCost)
    println(maxCount)
}
