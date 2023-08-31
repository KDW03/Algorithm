class Solution {
    fun solution(num_list: IntArray, n: Int): Array<IntArray> {
        val answer : MutableList<IntArray> = mutableListOf()
        
        for(i in 0 .. num_list.size - n step n) {
            answer.add(num_list.sliceArray(i until i + n))
        }
        
        return answer.toTypedArray()
    }
}