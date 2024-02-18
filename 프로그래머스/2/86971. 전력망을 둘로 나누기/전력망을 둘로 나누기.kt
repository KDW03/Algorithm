import kotlin.math.*

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var min = Int.MAX_VALUE

        val graph = makeGraph(n,wires)

        for(i in wires.indices) {
            // wires 중 하나를 제거하고 만든 그래프
            val (a,b) = wires[i]
            graph[a].remove(b)
            graph[b].remove(a)
            val visited = BooleanArray(n + 1)
            min = minOf(min,countComponent(n,graph,visited))
            graph[a].add(b)
            graph[b].add(a)
        }

        return min
    }

    fun countComponent(n : Int ,graph : Array<ArrayList<Int>>, visited : BooleanArray) : Int {

        fun dfs(start : Int = 1) {
            visited[start] = true
            for(near in graph[start]) {
                if(!visited[near]) {
                    dfs(near)
                }
            }
        }

        dfs()
        val count = visited.count { it }

        // 방문 된것 - 방문 안된 것
        return abs(2 * count - n)
    }


    fun makeGraph(n : Int, wires : Array<IntArray>) : Array<ArrayList<Int>> {

        val graph = Array(n + 1) { ArrayList<Int>() }

        for(j in wires.indices) {
            val (a,b) = wires[j]
            graph[a].add(b)
            graph[b].add(a)
        }

        return graph
    }
}