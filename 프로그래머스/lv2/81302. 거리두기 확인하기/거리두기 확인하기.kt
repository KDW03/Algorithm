import java.util.*
import kotlin.math.*

class Solution {
    val moveX = arrayOf(0,0,1,-1)
    val moveY = arrayOf(1,-1,0,0)
    
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: MutableList<Int> = mutableListOf()
        outer@for(place in places) {
            for(y in 0 until 5) {
                for(x in 0 until 5) {
                    if(place[y][x] == 'P') {
                        if(!bfs(y,x,place)) {
                            answer.add(0)
                            continue@outer
                        }
                    }
                }
            }
            answer.add(1)
        }
        
        return answer.toIntArray()
    }
    
    // y,x에서 bfs 실행
    fun bfs(y : Int, x : Int, arr : Array<String>) : Boolean{
        val visited = Array(5) { BooleanArray(5) { false } }
        val q : Queue<Pair<Int,Int>> = LinkedList()
        visited[y][x] = true
        q.add(Pair(y,x))
        while(q.isNotEmpty()){
            val nowCurrent = q.poll()   
            for(i in 0 until 4){
                val newY = nowCurrent.first + moveY[i]
                val newX = nowCurrent.second + moveX[i]
                if(!(newX in (0 .. 4) && newY in (0 .. 4) && !visited[newY][newX] && checkDistance(x,y,newX,newY))) continue
                when(arr[newY][newX]) {
                    'X' -> continue
                    'O' -> { 
                        q.add(Pair(newY,newX)) 
                        visited[newY][newX] = true
                        continue 
                    }
                    'P' -> return false 
                }
            }     
        }
        return true        
    }
    
    fun checkDistance(x : Int, y : Int, x1 : Int , y1 : Int) : Boolean = abs(x - x1) + abs(y - y1) <= 2
}