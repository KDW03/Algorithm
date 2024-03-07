fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
    }

    val answer = LongArray(n + 1) { Long.MAX_VALUE }
    answer[1] = 0

    for (i in 0 until n) {
        var update = false
        for (a in graph.indices) {
            for ((b, c) in graph[a]) {
                // 거쳐가는게 더 짧다면
                if (answer[a] != Long.MAX_VALUE && answer[b] > answer[a] + c) {
                    answer[b] = answer[a] + c
                    update = true
                }
            }
        }

        if (!update) break

        if (i == n - 1) {
            println(-1)
            return
        }
    }

    val sb = StringBuilder()
    answer.drop(2).forEach {
        if (it == Long.MAX_VALUE) sb.append(-1).append("\n")
        else {
            sb.append(it).append("\n")
        }
    }

    print(sb.toString())
}