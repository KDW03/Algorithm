class Solution {
    fun solution(common: IntArray): Int {
        val one = common[0]
        val two = common[1]
        val arithmetic = two - one
        val last = common.last()
        val isArithmetic = (common.last() - arithmetic == common[common.size - 2])
        return if (isArithmetic) {
            last + arithmetic
        } else {
            last * two / one
        }
    }
}