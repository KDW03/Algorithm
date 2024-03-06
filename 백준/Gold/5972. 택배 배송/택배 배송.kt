import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }

    val start = Pair(1, 0)
    val q: PriorityQueue<Pair<Int, Int>> = PriorityQueue { o1, o2 ->
        o1.second - o2.second
    }
    q.add(start)

    val visited = BooleanArray(n + 1)
    while (q.isNotEmpty()) {
        val (now, cost) = q.poll()

        if (visited[now]) continue
        visited[now] = true

        if (now == n) {
            println(cost)
            return
        }

        for ((d, c) in graph[now]) {
            if (visited[d]) continue
            q.add(Pair(d, c + cost))
        }
    }
}
