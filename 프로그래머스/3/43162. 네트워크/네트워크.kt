class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var count = 0
        val visited = BooleanArray(n)
        val graph = Array(n) { ArrayList<Int>() }
        
        computers.forEachIndexed { a , v ->
            // a와 b는 c가 1이면 연결 0이면 연결 x
            v.forEachIndexed { b , c ->
                if(a != b && c == 1) {
                    graph[a].add(b)
                }
            }
        }
        
        
        fun dfs(start : Int) {
            visited[start] = true
            for(nb in graph[start]) {
                if(!visited[nb]) dfs(nb)
            }
        }
        
        for(i in 0 until n) {
            if(!visited[i]) {
                count++
                dfs(i)
            }
        }
        
        
        return count
    }
}