import java.util.*

data class Position(val x : Int, val y : Int)

class Solution {
    fun solution(maps: Array<String>): Int {
        // 출발점 -> 레버 bfs
        var startPoint = Position(0,0)
        var laberPoint = Position(0,0)
        var exitPoint = Position(0,0)
        
        maps.forEachIndexed { x , v ->
            v.forEachIndexed { y, c ->
                
                if(c == 'S') {
                    startPoint = Position(x,y)
                }
                
                if(c == 'L') {
                    laberPoint = Position(x,y)
                }
                
                if(c == 'E') {
                    exitPoint = Position(x,y)
                }
                
            }
        }
        
        
        val moveX = arrayOf(0,0,-1,1)
        val moveY = arrayOf(1,-1,0,0)
        
        fun bfs(a : Position, b : Position) : Int {
            
            val visited = Array(maps.size) { BooleanArray(maps[0].length) }
            val q : Queue<Pair<Position,Int>> = LinkedList()
            
            q.add(Pair(a,0))
            visited[a.x][a.y] = true
            
            while(q.isNotEmpty()) {
                val (p,cost) = q.poll()
                val (x,y) = p
                
                if(p == b) return cost
                
                for(i in 0 until 4) {
                    val nx = x + moveX[i]
                    val ny = y + moveY[i]
                    
                    if(nx in maps.indices && ny in maps[0].indices && !visited[nx][ny] && maps[nx][ny] != 'X') {
                        visited[nx][ny] = true
                        q.add(Pair(Position(nx,ny),cost + 1))
                    }
                }
            }
            
            return -1
        }
        
        
        
        val toLCost = bfs(startPoint,laberPoint)
        if(toLCost == -1) return -1
        val toECost = bfs(laberPoint,exitPoint)
        if(toECost == -1) return -1
        
        return toLCost + toECost
    }
}