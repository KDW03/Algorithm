class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
      
        val days = progresses.mapIndexed { i , value -> 
            val remain = 100 - value
            remain / speeds[i] + if(remain % speeds[i] != 0) 1 else 0
        }
        
        var pre = days.first()
        var count = 0
        var answer = ArrayList<Int>()
        days.forEach {
            if(pre >= it) {
                count++
            } else {
                answer.add(count)
                count = 1
                pre = it
            }
        }
        answer.add(count)
        return answer.toIntArray()
    }
}