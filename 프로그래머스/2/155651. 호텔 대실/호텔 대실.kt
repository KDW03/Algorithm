import java.util.*

// 분으로 
data class Time(val inTime : Int, val outTime : Int)

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        
        // inTime outTime으로 mapping하고 inTime기준으로 오름차순 정렬
        val sortedTimes = book_time.map {
            val inTime = timeToMinute(it[0])
            val outTime = timeToMinute(it[1]) + 10
            Time(inTime,outTime)
        }.sortedBy {
            it.inTime
        }
        
        // 퇴실시간 기준으로 가장 빠른거
        val pq : PriorityQueue<Int> = PriorityQueue()
        sortedTimes.forEach {
            // 사용중이 방이 있고, 그 방의 퇴실시간이 입실시간보다 작거나 같다면 그 방 이용
            if(pq.isNotEmpty() && pq.peek() <= it.inTime) pq.poll()            
            // 입실
            pq.add(it.outTime)
      
        }
        
        // 모든 사람들을 다 받고 
        return pq.size
    }
    
    fun timeToMinute(time : String) : Int {
        val tmp = time.split(":").map{ it.toInt() }
        val hour = tmp[0] * 60
        val minute = tmp[1]
        return hour + minute 
    }
    
}