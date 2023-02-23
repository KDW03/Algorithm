class Solution {
    fun solution(sides: IntArray): Int {
        val max = sides.maxOrNull()
        val result = sides.sum()-max!!*2
        return if(result > 0) 1 else 2  
    }
}