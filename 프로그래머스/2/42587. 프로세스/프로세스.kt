import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        
        // 우선순위 Q
        val pq : PriorityQueue<Int> = PriorityQueue { o1,o2 -> o2 - o1 }
        val q : Queue<Pair<Int,Int>> = LinkedList()
        
        for(i in priorities.indices) {
            val p = priorities[i]
            pq.add(p)
            q.add(Pair(i,p))
        }
        var count = 0
        outer@while(pq.isNotEmpty()) {
            val topP = pq.poll()
            while(q.isNotEmpty()) {
                val (idx,p) = q.poll()
                if(topP != p) {
                    q.add(Pair(idx,p))
                }else{
                    count++
                    // 같다면 스케줄려 중지
                    if(idx == location) break@outer
                    // 다르다면 다음 우선순위 실행 진행
                    break
                }
            }
        }
        
        return count
    }
}