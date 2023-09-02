class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var left = 1
        var right = 200_000_000
        
        var answer = 0
        
        while(left <= right) {
            val mid = (left + right) / 2
            var cnt = 0
            
            for (stone in stones) {
                if (stone < mid) {
                    cnt++
                    if(cnt >= k) {
                        break
                    }
                }else {
                    cnt = 0
                }
            }
            
            if (cnt >= k) {
                right = mid - 1
            } else {
                left = mid + 1
                answer = mid
            }
        }
        return answer
    }
}
