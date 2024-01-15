import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val start = Pair(br.readLine().toInt(), 0)
    val graph: Array<ArrayList<Pair<Int, Int>>> = Array(V + 1) { ArrayList() }
    val ans = IntArray(V + 1) { Int.MAX_VALUE }
    val visited = BooleanArray(V + 1)
    repeat(E) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
    }

    val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue { o1, o2 -> o1.second - o2.second }
    pq.add(start)
    ans[start.first] = start.second

    while (pq.isNotEmpty()) {
        val (node, dist) = pq.poll()
        visited[node] = true

        for ((nNum, nDist) in graph[node]) {
            val newDist = dist + nDist
            if (ans[nNum] > newDist && !visited[nNum]) {
                ans[nNum] = newDist
                pq.add(Pair(nNum, newDist))
            }
        }
    }

    ans.drop(1).forEach {
        if (it == Int.MAX_VALUE) {
            println("INF")
        } else {
            println(it)
        }
    }
}
