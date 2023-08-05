class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int = absolutes.foldIndexed(0){ index, acc , i ->
        if(signs[index]) acc+i else acc-i
    }
}