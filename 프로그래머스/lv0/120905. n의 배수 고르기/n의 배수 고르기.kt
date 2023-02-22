class Solution {
    fun solution(n: Int, numlist: IntArray): IntArray = numlist.filter{it%n == 0}.toIntArray()
}