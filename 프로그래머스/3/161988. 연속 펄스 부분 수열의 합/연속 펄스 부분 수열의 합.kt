class Solution {
    fun solution(sequence: IntArray): Long {
        
        val n = sequence.size
        // + 로 시작
        val dpFirst = LongArray(n)
        dpFirst[0] = sequence.first().toLong()
        // - 로 시작
        val dpSecond = LongArray(n)
        dpSecond[0] = -sequence.first().toLong()
        
        var answer: Long = maxOf(dpFirst[0],dpSecond[0])
        
        for(i in 1 until n) {
            if(i % 2 == 0) {
                val fNow = sequence[i].toLong()
                val sNow = -sequence[i].toLong()
                dpFirst[i] = maxOf(fNow,dpFirst[i - 1] + fNow)
                dpSecond[i] = maxOf(sNow,dpSecond[i - 1] + sNow)
            } else {
                val fNow = -sequence[i].toLong()
                val sNow = sequence[i].toLong()
                dpFirst[i] = maxOf(fNow,dpFirst[i - 1] + fNow)
                dpSecond[i] = maxOf(sNow,dpSecond[i - 1] + sNow)
            }
            
            answer = maxOf(answer,dpFirst[i],dpSecond[i])
        }
        
        return answer
        
    }
}