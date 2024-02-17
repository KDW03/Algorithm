class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        // 0인덱스 값이 0인 누적합 Arr
        val sumArr = IntArray(sequence.size + 1) {
            if(it != 0) sequence[it - 1]
            else 0
        }
        
        for(i in 2 until sumArr.size) sumArr[i] += sumArr[i - 1]
        
        var start = 0
        var end = 1
        var minLength = Int.MAX_VALUE
        var answerStart = 0
        var answerEnd = 0
        while(sumArr.size > end) {
            // end 까지 누적합과 - start 까지 누적합
            val sum = sumArr[end] - sumArr[start]
            if(sum == k) {
                if(end - start < minLength) {
                    answerStart = start
                    answerEnd = end - 1
                    minLength = end - start
                }
                end++
            }else if(sum > k) {
                start++
            } else {
                end++
            }
        }
        
        return intArrayOf(answerStart,answerEnd)
    }
}