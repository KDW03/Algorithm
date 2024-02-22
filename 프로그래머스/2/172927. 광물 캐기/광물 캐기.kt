import java.util.*

data class Mock(val sums : Int, val arr : IntArray)

class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer = 0

        val wMinerals = minerals.take(picks.sumOf{ it } * 5).map { mineral ->
            when(mineral) {
                "diamond" -> 25
                "iron" -> 5
                else -> 1
            }
        }
        
        val tmp = ArrayList<Int>()
        val pq : PriorityQueue<Mock> = PriorityQueue{ o1, o2 ->
            o2.sums - o1.sums
        }

        for(w in wMinerals) {
            if(tmp.size == 5) {
                val sum = tmp.sumOf { it }
                pq.add(Mock(sum,tmp.toIntArray()))
                tmp.clear()
            }
            tmp.add(w)
        }

        pq.add(Mock(tmp.sumOf{ it },tmp.toIntArray()))

        picks.forEachIndexed { i,v ->
            
            val pickWeight = when(i) {
                0 -> 25
                1 -> 5
                else -> 1
            }
            
            for(i in 0 until v) {
                if(pq.isEmpty()) return answer
                val mock = pq.poll()
                answer += mock.arr.sumOf {
                    val value = it / pickWeight
                    if(value == 0) 1 else value
                }
            }
            
        }

        return answer
    }
}