class Solution {
    fun solution(slice: Int, n: Int): Int {
        var t = 1
        while(true) {
            if(slice * t >= n) break
            t++
        }
        return t
    }
}
