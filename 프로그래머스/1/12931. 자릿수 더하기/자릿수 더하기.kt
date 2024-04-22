class Solution {
    fun solution(n: Int): Int = n.toString().sumOf { it.digitToInt() }
}