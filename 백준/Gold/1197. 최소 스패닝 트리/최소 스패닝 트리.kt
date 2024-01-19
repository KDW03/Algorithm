import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val q: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
    val visited = BooleanArray(n + 1)
    val ans = IntArray(n + 1) { Int.MAX_VALUE }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }

    q.add(Pair(1, 0))
    ans[1] = 0

    while (q.isNotEmpty()) {
        val (current, _) = q.poll()
        if (visited[current]) continue
        visited[current] = true

        for ((next, weight) in graph[current]) {
            if (!visited[next] && weight < ans[next]) {
                ans[next] = weight
                q.add(Pair(next, weight))
            }
        }
    }

    println(ans.sumOf { it.toLong() } - Int.MAX_VALUE)
}
