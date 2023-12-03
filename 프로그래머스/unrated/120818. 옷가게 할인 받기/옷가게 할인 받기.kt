class Solution {
    fun solution(price: Int): Int {
        val discount: Double = when {
            price >= 500000 -> 0.20
            price >= 300000 -> 0.10
            price >= 100000 -> 0.05
            else -> 0.00
        }

        val finalPrice = price * (1 - discount)
        return finalPrice.toInt()
    }
}