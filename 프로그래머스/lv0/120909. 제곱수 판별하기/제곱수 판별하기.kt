import kotlin.math.*

class Solution {
    fun solution(n: Int): Int = if (n.toDouble().pow(0.5).toInt().toDouble().pow(2).toInt() == n) 1 else 2
}