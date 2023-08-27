class Solution {

    private lateinit var gInfo: IntArray
    private lateinit var gEdges: Array<IntArray>
    private var maxSheepCnt = 0

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        gInfo = info
        gEdges = edges
        
        dfs(0, BooleanArray(info.size), 0, 0)
        return maxSheepCnt
    }

    private fun dfs(idx : Int , visited: BooleanArray, sheepCnt: Int, wolfCnt : Int) {
        visited[idx] = true
        val (newSheepCnt, newWolfCnt) = when (gInfo[idx]) {
            0 -> sheepCnt + 1 to wolfCnt
            else -> sheepCnt to wolfCnt + 1
        }
        
        maxSheepCnt = maxOf(newSheepCnt, maxSheepCnt)
        
        if(newSheepCnt > newWolfCnt) {
            gEdges.filter { visited[it[0]] && !visited[it[1]] }.forEach {
                dfs(it[1], visited.copyOf(), newSheepCnt, newWolfCnt)
            }
        }
    }
}
