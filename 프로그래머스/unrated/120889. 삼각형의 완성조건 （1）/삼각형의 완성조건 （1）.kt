class Solution {
    fun solution(sides: IntArray): Int {
        val max = sides.maxOf{ it }
        return if(sides.sumOf{ it } > 2 * max) 1 else 2
    }
}


