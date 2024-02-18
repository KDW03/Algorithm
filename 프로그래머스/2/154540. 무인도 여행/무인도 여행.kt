class Solution {
    fun solution(maps: Array<String>): IntArray {
        var answer: ArrayList<Int> = ArrayList()
        val visited = Array(maps.size) { BooleanArray(maps[0].length) }
        for(x in maps.indices) {
            for(y in maps[0].indices) {
                // x가 아니고 방문하지 않았다면 하나의 섬 형성                 
                if(maps[x][y] != 'X' && !visited[x][y]) {
                    answer.add(dfs(x,y,maps,visited))
                }
            }
        }
        
        return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }
    
    val moveX = arrayOf(-1,1,0,0)
    val moveY = arrayOf(0,0,1,-1)
    
    fun dfs(x : Int, y : Int, maps: Array<String>, visited : Array<BooleanArray>) : Int {
        visited[x][y] = true
        var sums = maps[x][y].digitToInt()
        
        for(i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]
            if(nx in maps.indices && ny in maps[0].indices && maps[nx][ny] != 'X' && !visited[nx][ny]) {
                sums += dfs(nx,ny,maps,visited)
            }
        }
        
        return sums
    }
}