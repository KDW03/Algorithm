import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {        
        

        val q : Queue<Pair<Int,Int>> = LinkedList()
        q.add(Pair(x,0))
        val visited = BooleanArray(y + 1)
        
        while(q.isNotEmpty()) {
            val (now,cost) = q.poll()
            if(now == y) return cost
            
            val first = now + n
            if(first <= y) {
                if(!visited[first]) {
                    q.add(Pair(first, cost + 1))
                    visited[first] = true
                }
            }
            
            val second = 2 * now
            if(second <= y)  {
                if(!visited[second]) {
                    q.add(Pair(second, cost + 1))
                    visited[second] = true
                }
            }
            
            val third = 3 * now
            if(third <= y) {
                if(!visited[third]) {
                    q.add(Pair(third, cost + 1))
                    visited[third] = true
                }
            }
        }
        
        return -1
    }
}