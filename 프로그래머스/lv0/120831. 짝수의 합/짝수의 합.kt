class Solution {
    fun solution(n: Int): Int = (1..n).filter{ it % 2 == 0 }.sumOf{ it }
}