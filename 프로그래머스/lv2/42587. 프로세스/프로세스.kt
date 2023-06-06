import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val t = priorities.mapIndexed { index, i ->
            Pair(index, i)
        }
        val find = t[location]
        val q : Queue<Pair<Int,Int>> = LinkedList(t)
        val pq = priorities.sortedDescending()
        var answer = 0
        while (true) {
            val tmp = q.poll()
            if (tmp.second == pq[answer]){
                if (tmp == find) return answer + 1 
                answer++
            }else{
                q.add(tmp)
            }
        }
    }
}