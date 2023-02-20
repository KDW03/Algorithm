class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for (i in n.toString()) {
            answer += Character.getNumericValue(i)
        }

        return answer
    }
}