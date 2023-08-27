import kotlin.math.*

class Solution {
    fun solution(n: Int): Int {
        val root = sqrt(n.toDouble())
        // 
        return if (root.toInt().toDouble() == root) 1 else 2
    }
}