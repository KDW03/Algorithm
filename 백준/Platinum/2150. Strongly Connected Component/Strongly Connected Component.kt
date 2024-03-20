fun main() {
    val br = System.`in`.bufferedReader()
    val (v, e) = readLine()!!.split(" ").map { it.toInt() }

    val graph = Array(v + 1) {
        ArrayList<Int>()
    }

    val graphRef = Array(v + 1) {
        ArrayList<Int>()
    }

    repeat(e) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graphRef[b].add(a)
    }

    val visited = BooleanArray(v + 1)
    val order = ArrayList<Int>()
    fun dfs(i: Int) {
        visited[i] = true

        for (near in graph[i]) {
            if (visited[near]) continue
            dfs(near)
        }

        order.add(i)
    }

    fun dfsRef(i: Int, sccs: ArrayList<Int>) {
        sccs.add(i)
        visited[i] = true

        for (near in graphRef[i]) {
            if (visited[near]) continue
            dfsRef(near,sccs)
        }
    }

    for (i in 1..v) {
        if (visited[i]) continue
        dfs(i)
    }

    visited.fill(false)
    val scc = ArrayList<List<Int>>()
    for (i in order.reversed()) {
        if (visited[i]) continue
        val sccs = ArrayList<Int>()
        dfsRef(i,sccs)
        val answer = sccs.sorted().toMutableList()
        answer.add(-1)
        scc.add(answer)
    }

    scc.sortBy {
        it.first()
    }

    println(scc.size)
    scc.forEach {
        println(it.joinToString(" "))
    }

}