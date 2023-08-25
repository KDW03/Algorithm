class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answer = mutableListOf<Int>()
        arr.forEach {
            if(it % divisor == 0) answer.add(it)
        }
        
        return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }
}