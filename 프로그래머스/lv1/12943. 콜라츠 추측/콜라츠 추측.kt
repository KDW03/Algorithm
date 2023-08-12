class Solution {
    fun solution(num: Int): Int {
        var count = 0
        var n = num.toLong()
        if(n == 1L) return 0
        while(n != 1L){
            if(n % 2L == 0L) n /= 2
            else n = n * 3 + 1
            if(++count >= 500) return -1
        }
        return count
    }
}