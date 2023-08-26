class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer = 0

        val dic = mutableMapOf<String, Int>()
        for (i in want.indices) {
            dic[want[i]] = number[i]
        }

        for (i in 0 until discount.size - 9) {
            val subListCounter = discount.slice(i until i + 10).groupBy { it }.mapValues { it.value.size }

            if (dic == subListCounter) {
                answer++
            }
        }

        return answer
    }
}

