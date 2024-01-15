fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    repeat(n - 1) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(b, c))
        graph[b].add(Pair(a, c))
    }

    fun dfs(start: Int): Pair<Int, Int> {
        val visited = BooleanArray(n + 1)

        fun findMax(parent: Int): Pair<Int, Int> {
            visited[parent] = true
            var maxChild = parent
            var maxDist = 0

            for ((child, dist) in graph[parent]) {
                if (!visited[child]) {
                    val result = findMax(child)
                    val cost = result.second + dist
                    if (cost > maxDist) {
                        maxDist = cost
                        maxChild = result.first
                    }
                }
            }

            return Pair(maxChild, maxDist)
        }

        return findMax(start)
    }

    println(dfs(dfs(start = 1).first).second)
}