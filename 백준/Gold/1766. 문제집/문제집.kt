import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Int>() }
    val degree = IntArray(n + 1)
    degree[0] = Int.MAX_VALUE
    val q: PriorityQueue<Int> = PriorityQueue()

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        degree[b]++
    }

    for (i in degree.indices) if (degree[i] == 0) q.add(i)

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
