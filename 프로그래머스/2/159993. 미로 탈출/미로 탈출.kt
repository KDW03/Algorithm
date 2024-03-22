import java.util.*

data class Point(val x : Int = 0, val y : Int = 0)

class Solution {
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        
        var start = Point()
        var lever = Point()
        var exit = Point()
        
        
        maps.forEachIndexed { x,v ->
            v.forEachIndexed { y, c ->
                when(c) {
                    'S' -> {
                        start = Point(x,y)
                    }
                    'L' -> {
                        lever = Point(x,y)
                    }
                    'E' -> {
                        exit = Point(x,y)
                    }
                }
            }
        }
        
        val moveX = arrayOf(0,0,-1,1)
        val moveY = arrayOf(1,-1,0,0)

        var distMap = Array(maps.size) { IntArray(maps[0].length){ 10001 } }
        distMap[start.x][start.y] = 0
        
        fun bfs(start : Point, find : Point) : Int {
            val q : Queue<Pair<Point,Int>> = LinkedList()
            
            q.add(Pair(start,0))
            
            while(q.isNotEmpty()) {
                val (p,cost) = q.poll()
                
                if(p == find) {
                    return cost
                }
                
                for(i in 0 until 4) {
                    val nx = p.x + moveX[i]
                    val ny = p.y + moveY[i]
                    val newCost = cost + 1
                    if(nx in maps.indices && ny in maps[0].indices && maps[nx][ny] != 'X' && distMap[nx][ny] > newCost) {
                        distMap[nx][ny] = newCost
                        q.add(Pair(Point(nx,ny),newCost))
                    }
                }
            }
            return -1
        }
        
        
        // 시작점 To 레버
        val mDistToLever = bfs(start = start, find = lever)
        if(mDistToLever == -1) return -1
        
        // 레버 To 출구
        distMap = Array(maps.size) { IntArray(maps[0].length){ 10001 } }
        val mDistToEixt = bfs(start = lever, find = exit)
        if(mDistToEixt == -1) return -1
        
        
        return mDistToLever + mDistToEixt
    }
}