class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val map = progresses.mapIndexed { i , v -> 
            val remain = 100 - v 
            remain / speeds[i] + if(remain % speeds[i] == 0) 0 else 1
        }
        
        val answer = mutableListOf<Int>()
        var count = 1
        var pre = map[0]
        for(now in map.drop(1)){
            if(now <= pre) count++
            else {
                answer.add(count)
                pre = now
                count = 1
            }
        }
        
        answer.add(count)
        
        
        return answer.toIntArray()
    }
}