import java.util.LinkedList
import java.util.Queue
import kotlin.math.cos

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(n) { arrayListOf<Int>() }
        val degree = IntArray(n)
        val costs = br.readLine().split(" ").map { it.toInt() }
        val ans = costs.toIntArray().copyOf()
        repeat(k) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() - 1 }
            graph[a].add(b)
            degree[b]++
        }
        val w = br.readLine().toInt()
        val q: Queue<Int> = LinkedList()
        for (i in degree.indices) {
            val dgCount = degree[i]
            if (dgCount == 0) {
                q.add(i)
            }
        }
        while (q.isNotEmpty()) {
            val p = q.poll()

            for (compo in graph[p]) {
                degree[compo]--
                ans[compo] = maxOf(ans[compo], ans[p] + costs[compo])
                if (degree[compo] == 0) q.add(compo)
            }
        }

        sb.append(ans[w - 1]).append("\n")
    }
    println(sb.toString())
}
