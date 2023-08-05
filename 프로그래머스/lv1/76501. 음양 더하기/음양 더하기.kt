class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int = absolutes.mapIndexed{ i , num ->
        if(signs[i]) num else -num
    }.sum()
}