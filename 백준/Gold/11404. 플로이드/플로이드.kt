const val max : Long = 100000 * 100 + 1
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n) { LongArray(n) { max } }

    repeat(br.readLine().toInt()) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a - 1][b - 1] = minOf(graph[a - 1][b - 1], c.toLong())
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) graph[i][i] = 0
                graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    graph.forEach {
        println(it.map { value -> if (value == max) 0 else value }.joinToString(" "))
    }

}
