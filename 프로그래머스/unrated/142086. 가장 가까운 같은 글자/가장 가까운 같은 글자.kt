class Solution {
    fun solution(s: String): IntArray {
        val reverseArray = s.toCharArray().reversed()
        val answer = IntArray(s.length)
        
        reverseArray.forEachIndexed { i, v ->
            val index = reverseArray.drop(i + 1).indexOfFirst { it == v }
            answer[i] = if (index == -1) -1 else index + 1
        }

        return answer.reversedArray()
    }
}