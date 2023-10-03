class Solution {
    fun solution(num: Int, total: Int): IntArray {
        var start = total / num - num / 2 + if(total % num != 0) 1 else 0
        return IntArray(num) { it + start }
    }
}