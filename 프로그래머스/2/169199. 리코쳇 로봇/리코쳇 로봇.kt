import java.util.*

data class Point(val x : Int, val y :Int)

class Solution {
    fun solution(board: Array<String>): Int {

        var sPoint = Point(0,0)
        var gPoint = Point(0,0)
        
        board.forEachIndexed { x , v ->
            v.forEachIndexed { y , c ->
                if(c == 'R') sPoint = Point(x,y)
                if(c == 'G') gPoint = Point(x,y)
            }
        }
        
        val moveX = arrayOf(0,0,-1,1)
        val moveY = arrayOf(1,-1,0,0)
        
        val visited = Array(board.size) { BooleanArray(board[0].length) }
        val q : Queue<Pair<Point,Int>> = LinkedList()
        
        q.add(Pair(sPoint,0))
        
        while(q.isNotEmpty()) {
            val (p,cost) = q.poll()
            if(p == gPoint) return cost
            val (x,y) = p
            
            for(i in 0 until 4) {
                var nx = x + moveX[i]
                var ny = y + moveY[i]
                
                // 범위내거나 장애물이 아니라면 계속 미끄러지기
                while(nx in board.indices && ny in board[0].indices && board[nx][ny] != 'D') {
                    nx += moveX[i]
                    ny += moveY[i]
                }
                
                // 마지막 다시 뒤로 후진
                nx -= moveX[i]
                ny -= moveY[i]
                
                // 방문한 곳이 아니라면
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true
                    q.add(Pair(Point(nx,ny),cost + 1))
                }
            }
        }
        
        return -1
    }
}