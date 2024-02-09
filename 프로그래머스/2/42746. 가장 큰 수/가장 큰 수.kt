class Solution {
    fun solution(numbers: IntArray): String {

        // 1000까지 각각의 자리수의 대소 비교해서 정렬
        val answer = numbers.map { it.toString() }.sortedWith { o1, o2 ->
            (o2 + o1).compareTo(o1 + o2)
        }.joinToString("")
        return if (answer.first() == '0') "0" else answer
    }
}