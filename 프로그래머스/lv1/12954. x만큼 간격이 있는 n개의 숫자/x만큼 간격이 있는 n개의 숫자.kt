class Solution {
    fun solution(x: Int, n: Int): LongArray = LongArray(n) { (it + 1) * x.toLong() }
}