import java.util.Deque
import java.util.LinkedList

data class Process(val idx : Int, val priority : Int)
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var count = 0

        val processes = priorities.mapIndexed { i,v ->
            Process(i,v)
        }

        val deque : Deque<Process> = LinkedList(processes)
        while (deque.isNotEmpty()){
            val p = deque.pollFirst()
            if (deque.isEmpty() || deque.maxOf { it.priority } <= p.priority){
                count++
                if (p.idx == location) break
            }else{
                deque.addLast(p)
            }
        }

        return count
    }
}