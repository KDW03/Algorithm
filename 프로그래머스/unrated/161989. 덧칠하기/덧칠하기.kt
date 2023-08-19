class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer = 0
        var nextSection = 0
        section.forEach {        
            if (it >= nextSection) {
                answer++
                nextSection = it + m
            }
        }
        return answer
    }
}