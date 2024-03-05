import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, d) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(d + 1) { x -> arrayListOf(Pair(x + 1, 1)) }
    val visited = BooleanArray(d + 1)

    repeat(n) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        if (b - a > c && b <= d) {
            graph[a].add(Pair(b, c))
        }
    }

    val q: PriorityQueue<Pair<Int, Int>> = PriorityQueue { o1, o2 ->
        o1.second - o2.second
    }

    for (road in graph[0]) {
        q.add(road)
    }

    visited[0] = true

    while (q.isNotEmpty()) {
        val (dest, cost) = q.poll()
        if (visited[dest]) continue
        visited[dest] = true

        if (dest == d) {
            println(cost)
            return
        }

        for ((ddest, ccost) in graph[dest]) {
            if (!visited[ddest]) {
                q.add(Pair(ddest, ccost + cost))
            }
        }
    }
}