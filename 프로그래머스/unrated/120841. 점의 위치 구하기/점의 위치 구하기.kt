class Solution {
    fun solution(dot: IntArray): Int {
        val x = dot[0]
        val y = dot[1]
        return if(x > 0) {
            if(y > 0) 1
            else 4
        }else {
            if(y > 0) 2
            else 3
        }
    }
}