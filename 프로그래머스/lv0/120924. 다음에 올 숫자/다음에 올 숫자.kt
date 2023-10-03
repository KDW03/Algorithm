class Solution {
    fun solution(common: IntArray): Int {
        var answer: Int = 0
        
        // 등차 인지 등비인지 판별
        val first = common[0]
        val second = common[1]
        val third = common[2]
        val last = common.last()
        
        val ab = second - first
        val mu = if(first != 0) second / first else 1
        
        return if(third - second == ab) last + ab else last *  mu 
    }
}