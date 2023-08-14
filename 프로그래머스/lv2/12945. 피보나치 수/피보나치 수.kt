class Solution {
    fun solution(n: Int): Int {
        var prevprev = 0
        var prev = 1
        var answer = 0
        for(i in 2 .. n) {
            answer = (prevprev + prev) % 1234567
            prevprev = prev
            prev = answer
        }
        return answer
    }
}