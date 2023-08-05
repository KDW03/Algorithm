class Solution {
    fun solution(numbers: IntArray, n: Int): Int =
        numbers.reduce { total, num -> if (total > n) return total else total + num }
}