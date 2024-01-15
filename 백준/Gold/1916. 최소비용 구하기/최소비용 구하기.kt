import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    val ans = IntArray(n + 1) { Int.MAX_VALUE }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
    }

    val (u, v) = br.readLine().split(" ").map { it.toInt() }

    val q: PriorityQueue<Pair<Int, Int>> = PriorityQueue() { o1, o2 -> o1.second - o2.second }
    q.add(Pair(u, 0))
    ans[u] = 0

    while (q.isNotEmpty()) {
        val (pNode, pDist) = q.poll()
        if (pNode == v) {
            println(pDist)
            return
        }
        for ((nNode, nDist) in graph[pNode]) {
            val cost = nDist + pDist
            if (ans[nNode] > cost) {
                ans[nNode] = cost
                q.add(Pair(nNode, cost))
            }
        }
    }
}

