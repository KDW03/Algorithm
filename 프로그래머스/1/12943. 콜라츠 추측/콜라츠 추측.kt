class Solution {
    fun solution(num: Int): Int {
        var n = num.toLong()
        var count = 0
        while(n != 1L) {
            if(count == 500) return -1            
            
            if(n % 2L == 0L) {
                n /= 2
            }else {
                n *= 3
                n += 1
            }
            
            count++
        }
        return count
    }
}