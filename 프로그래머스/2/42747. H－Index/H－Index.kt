// 시간복잡도 nLog(n)
class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        
        var start = 0
        var end = citations.size
        
        // logn
        while(start <= end) {
            val h = (start + end) / 2
            println(h)
            // n
            val count = citations.count { it >= h }
            if(count >= h) {
                answer = h
                start = h + 1
            } else {
                end = h - 1
            }
        }
        
        return answer
    }
}