import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    repeat(m) { cost ->
        // a에서 b 가는거 초기에 cost + xM 주기로 켜짐
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, cost))
        graph[b].add(Pair(a, cost))
    }

    val visited = BooleanArray(n + 1)
    val q: PriorityQueue<Pair<Int, Long>> = PriorityQueue { o1, o2 ->
        o1.second.compareTo(o2.second)
    }

    q.add(Pair(1, 0))
    while (q.isNotEmpty()) {
        val (dest, cost) = q.poll()

        if (dest == n) {
            println(cost)
            return
        }

        if (visited[dest]) continue
        visited[dest] = true

        for ((d, c) in graph[dest]) {
            if (visited[d]) continue
            // 길 건너는 비용 1
            if (cost > c) {
                // 현재 c보다 dest까지 오는 cost가 크다면 건널 수 있는 주기 계산
                val diff = cost - c
                val t = diff / m + if (diff % m > 0) 1 else 0
                val newCost = c + (t * m) + 1
                q.add(Pair(d, newCost))
            } else {
                q.add(Pair(d, c.toLong() + 1))
            }
        }
    }

}