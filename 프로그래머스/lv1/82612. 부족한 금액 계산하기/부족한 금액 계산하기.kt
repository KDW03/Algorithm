class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        val p = price.toLong()
        val t = (0..count).sumOf { p * it } - money
        return if (t <= 0) 0 else t
    }
}