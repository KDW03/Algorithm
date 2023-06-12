
class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        val size = wires.size
        var min = Int.MAX_VALUE
        for(i in 0 until size){
            val tmp = wires.slice(IntRange(0,i-1)) + wires.slice(IntRange(i+1,size-1))
            val graph : Array<ArrayList<Int>> = Array(n+1){ arrayListOf() }
            val visited = BooleanArray(n+1)
            for(edge in tmp) {
                val a = edge[0]
                var b = edge[1]
                graph[a].add(b)
                graph[b].add(a)
            }
            dfs(graph,1,visited)

            min = minOf(min,Math.abs(n - visited.count{ it == true } - visited.count{it == true} ))

        }
        return min
    }

    fun dfs(graph : Array<ArrayList<Int>>,start: Int, visited : BooleanArray){
        visited[start] = true
        for(i in graph[start]){
            if(visited[i]) continue
            dfs(graph,i,visited)
        }
    }

    // 하나씩 끊고 dfs 반복
    // 방문된 거 
    // 방문안 된 거 차이
    // 
}