class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray = num_list.filterIndexed{ i , v -> i % n == 0 }.toTypedArray().toIntArray()
}