import java.util.*
import kotlin.collections.ArrayList

fun dijkstra(start: Int, graph: Array<ArrayList<Pair<Int, Int>>>): IntArray {
    val dist = IntArray(graph.size) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.add(Pair(start, 0))
    dist[start] = 0

    while (pq.isNotEmpty()) {
        val (current, currentDist) = pq.poll()
        if (dist[current] < currentDist) continue
        for ((next, weight) in graph[current]) {
            val nextDist = currentDist + weight
            if (nextDist < dist[next]) {
                dist[next] = nextDist
                pq.add(Pair(next, nextDist))
            }
        }
    }
    return dist
}

fun main() {
    val br = System.`in`.bufferedReader()
    val case = br.readLine().toInt()

    repeat(case) {
        val (n, m, t) = br.readLine().split(" ").map { it.toInt() }
        val (s, g, h) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(n + 1) { arrayListOf<Pair<Int, Int>>() }

        repeat(m) {
            val (a, b, d) = br.readLine().split(" ").map { it.toInt() }
            graph[a].add(Pair(b, d))
            graph[b].add(Pair(a, d))
        }

        val distFromS = dijkstra(s, graph)
        val distFromG = dijkstra(g, graph)
        val distFromH = dijkstra(h, graph)

        val answerList = ArrayList<Int>()

        repeat(t) {
            val x = br.readLine().toInt()
            if (distFromS[x] == distFromS[g] + graph[g].find { it.first == h }!!.second + distFromH[x] ||
                distFromS[x] == distFromS[h] + graph[h].find { it.first == g }!!.second + distFromG[x]) {
                answerList.add(x)
            }
        }

        answerList.sorted().joinToString(" ").let {
            println(it)
        }
    }
}
