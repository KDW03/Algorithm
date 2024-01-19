import java.util.PriorityQueue

const val MAX = 10001

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n + 1) { arrayListOf<Pair<Int, Int>>() }
    val visited = BooleanArray(n + 1)
    val ans = IntArray(n + 1) { MAX }
    val q: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
    repeat(br.readLine().toInt()) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }

    q.add(Pair(1, 0))
    ans[0] = 0
    ans[1] = 0

    while (q.isNotEmpty()) {
        val (a, _) = q.poll()
        visited[a] = true

        for ((b, abCost) in graph[a]) {
            if (!visited[b]) {
                if (ans[b] > abCost) {
                    ans[b] = abCost
                    q.add(Pair(b, abCost))
                }
            }
        }
    }

    println(ans.sumOf { it })
}
