fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr: Array<ArrayList<Pair<Int, Int>>> = Array(n + 1) { ArrayList() }

    repeat(n) {
        val tmp = br.readLine().split(" ").map { it.toInt() }
        val nowNode = tmp[0]

        for (i in 1 until tmp.size - 1 step 2) {
            val nodeNum = tmp[i]
            val dist = tmp[i + 1]
            arr[nowNode].add(Pair(nodeNum, dist))
        }
    }

    fun dfs(start: Int, graph: Array<ArrayList<Pair<Int, Int>>>): Pair<Int, Int> {
        val visited = BooleanArray(graph.size) { false }
        var maxDistance = 0
        var farthestNode = start

        fun dfsRecursive(node: Int, distance: Int) {
            visited[node] = true
            if (distance > maxDistance) {
                maxDistance = distance
                farthestNode = node
            }

            for (edge in graph[node]) {
                if (!visited[edge.first]) {
                    dfsRecursive(edge.first, distance + edge.second)
                }
            }
        }

        dfsRecursive(start, 0)
        return Pair(farthestNode, maxDistance)
    }

    val firstDFS = dfs(1, arr)
    val secondDFS = dfs(firstDFS.first, arr)

    println(secondDFS.second)
}