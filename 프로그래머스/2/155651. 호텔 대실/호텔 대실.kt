import java.util.*

data class BookTime(val startMinute: Int, val endMinute : Int) 

fun timeToMinute(time : String) : Int {
    val tmp = time.split(":").map{ it.toInt() }
    return tmp[0] * 60 + tmp[1]
}

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        
        val bookTimes = book_time.map { 
            BookTime(timeToMinute(it[0]),timeToMinute(it[1]) + 10)
        }
        
        val startQ = PriorityQueue<BookTime> {
            o1,o2 ->
            o1.startMinute - o2.startMinute
        }
        
        startQ.addAll(bookTimes)
        
        val houseQ = PriorityQueue<BookTime> {
            o1,o2 ->
            o1.endMinute - o2.endMinute
        }
        
        while(startQ.isNotEmpty()) {
            val time = startQ.poll()
            
            if(houseQ.isNotEmpty() && houseQ.peek().endMinute <= time.startMinute) {
                houseQ.poll()
            }
            
            houseQ.add(time)
        }
        
        return houseQ.size
    }
}