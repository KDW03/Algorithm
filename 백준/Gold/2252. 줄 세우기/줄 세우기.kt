import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph: Array<ArrayList<Int>> = Array(n + 1) { ArrayList() }
    val degree = IntArray(n + 1)

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        degree[b]++
    }

    val q: Queue<Int> = LinkedList()

    for (i in degree.indices) {
        if (i == 0) continue
        val dgCount = degree[i]
        if (dgCount == 0) q.add(i)
    }
    val sb = StringBuilder()
    while (q.isNotEmpty()) {
        val p = q.poll()
        sb.append(p).append(" ")
        for (compo in graph[p]) {
            degree[compo]--
            if (degree[compo] == 0) q.add(compo)
        }
    }
    println(sb.toString())
}