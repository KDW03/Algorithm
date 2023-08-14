class Solution {
    fun solution(s: String): Int {
        
        var min = Int.MAX_VALUE
        if(s.length <= 1) return 1
        for(splitCount in 1 .. s.length / 2) {
            var repleCount = 1
            var len = s.length
            var pre = s.substring(0 until splitCount)            
            for(j in splitCount until s.length step splitCount) {
                val next = s.substring(j until minOf(j + splitCount , s.length))
                if(next == pre) repleCount++
                else {
                    if(repleCount >= 2) len -= ((repleCount - 1) * splitCount - repleCount.toString().length)
                    repleCount = 1
                    pre = next
                }
            }
            if(repleCount >= 2) len -= ((repleCount - 1) * splitCount - repleCount.toString().length)
            min = minOf(min,len)
            len = 0
        }
        
        return min
    }
}