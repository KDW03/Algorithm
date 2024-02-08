var maxCount = 0
class Solution {
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size)
        dfs(k,dungeons,visited)
        return maxCount
    }
    
    
    fun dfs(remain : Int, dungeons: Array<IntArray>, visited : BooleanArray, count : Int = 0) {
        // 모든 던전에 대해서 순서가 있는 조합
        for(i in dungeons.indices) {
            // 최소피로도, 소비피로도
            val (minP,sP) = dungeons[i]
            // 방문하지않았고 피로도 가능하다면
            if(!visited[i] && remain >= minP) {
                // 방문 처리 후 들어가주기
                visited[i] = true
                dfs(remain - sP,dungeons,visited,count + 1)
                maxCount = maxOf(maxCount,count + 1)
                // 방문 처리 해제 해주고 다른 경우 탐색
                visited[i] = false
            }
            
        }
        
    }
    
}