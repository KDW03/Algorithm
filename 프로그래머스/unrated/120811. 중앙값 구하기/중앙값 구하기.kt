class Solution {
    fun solution(array: IntArray): Int {
        val size = array.size
        
        return array.sorted()[size/2]
    }
}