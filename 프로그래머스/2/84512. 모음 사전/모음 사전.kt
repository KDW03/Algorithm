class Solution {
    fun solution(word: String): Int { 
        val weights = IntArray(5) { 1 }
        for(i in weights.size - 2 downTo 0) {
            // 이전까지의 경우의 수 중 자리수 추가라 5개중 1개 뽑는 경우 추가
            weights[i] = (weights[i + 1] * 5) + 1
        }
        val charToValue = mapOf('A' to 0, 'E' to 1, 'I' to 2, 'O' to 3, 'U' to 4)
        var answer = 0
        
        word.forEachIndexed { index, char ->
            answer += charToValue[char]!! * weights[index] + 1
        }
        
        return answer
    }
}