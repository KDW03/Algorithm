class Solution {
    fun solution(x: Int): Boolean = x % x.toString().map{ it.digitToInt() }.sum() == 0
}