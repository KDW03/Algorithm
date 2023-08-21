class Solution {
    fun solution(n: Int): Int = n.toString().map { it.digitToInt() }.reduce { acc, i -> acc + i }
}