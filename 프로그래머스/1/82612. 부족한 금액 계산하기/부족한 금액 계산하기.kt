class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var remain = money.toLong()
        repeat(count) {
            remain -= price * (it + 1)
        }
        return if(remain >= 0) 0 else -remain
    }
}