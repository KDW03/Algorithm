import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val (n, m, k, x) = br.readLine().split(" ").map { it.toInt() }
    val dkTable = IntArray(n + 1) { Int.MAX_VALUE }
    val graph = Array<ArrayList<Int>>(n+1) { arrayListOf() }
    repeat(m) {
        val (dest, value) = br.readLine().split(" ").map { it.toInt() }
        graph[dest].add(value)
    }
    bfs(x, dkTable, graph)


    for((idx,value) in dkTable.withIndex()){
        if(value == k) sb.append(idx).append("\n")
    }

    if(sb.toString() == ""){
        print(-1)
    }else{
        print(sb.toString())
    }


}

fun bfs(start: Int, dkTable: IntArray, graph: Array<ArrayList<Int>>) {
    val q: Queue<Int> = LinkedList()
    q.add(start)
    dkTable[start] = 0
    while (q.isNotEmpty()) {
        val now = q.poll()
        for (adjust in graph[now]) {
            if (dkTable[adjust] <= dkTable[now] + 1) continue
            dkTable[adjust] = dkTable[now] + 1
            q.add(adjust)
        }
    }

}
