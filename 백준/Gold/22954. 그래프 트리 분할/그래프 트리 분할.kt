data class PartTree(
    val vertexs: ArrayList<Int> = arrayListOf(),
    val edges: ArrayList<Int> = arrayListOf()
)

fun main() {
    val br = System.`in`.bufferedReader()
    // 정점의 개수, 간선의 개수
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    // 간선 idx와 destNode
    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    repeat(m) {
        val idx = it + 1
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Pair(idx, b))
        graph[b].add(Pair(idx, a))
    }

    if (n <= 2 || m < 1) {
        println(-1)
        return
    }
    // dfs로 현재 몇개 트리인지
    // 2개보다 크게 개수면 이미 의미 x
    // -1
    val visited = BooleanArray(n + 1)

    fun dfs(start: Int, partTree: PartTree, except: Int) {
        visited[start] = true
        partTree.vertexs.add(start)
        for ((i, v) in graph[start]) {
            if (visited[v] || v == except) continue
            partTree.edges.add(i)
            dfs(v, partTree, except)
        }
    }

    val trees = ArrayList<PartTree>()
    for (i in 1..n) {
        if (trees.size > 2) {
            println(-1)
            return
        }
        if (visited[i]) continue
        visited[i] = true
        val partTree = PartTree()
        dfs(i, partTree, -1)
        trees.add(partTree)
    }

    val sb = StringBuilder()

    fun makeAnswer(tree1: PartTree, tree2: PartTree) {
        sb.append("${tree1.vertexs.size} ${tree2.vertexs.size}").append("\n")
        sb.append(tree1.vertexs.joinToString(" ")).append("\n")
        sb.append(tree1.edges.joinToString(" ")).append("\n")
        sb.append(tree2.vertexs.joinToString(" ")).append("\n")
        sb.append(tree2.edges.joinToString(" ")).append("\n")
        println(sb.toString().trimEnd())
    }

    // 2개
    if (trees.size == 2) {
        if (trees[0].vertexs.size == trees[1].vertexs.size) {
            println(-1)
            return
        } else {
            makeAnswer(trees[0], trees[1])
            return
        }
    }

    if (trees.size == 1) {
        val tree = trees.first()
        val leafNode = tree.vertexs.last()
        visited.fill(false)
        val partTree = PartTree()
        for (i in 1..2) {
            if (visited[i] || i == leafNode) continue
            dfs(i, partTree, leafNode)
        }
        if (partTree.vertexs.size == n - 1) {
            makeAnswer(partTree, PartTree().apply { vertexs.add(leafNode) })
        } else println(-1)
    }else {
        println(-1)
    }
}
