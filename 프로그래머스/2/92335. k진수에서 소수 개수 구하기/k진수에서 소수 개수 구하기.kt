class Solution {
    fun solution(n: Int, k: Int): Int {
        // k진수 변환
        val kNum = n.toString(k)
        val nums = kNum.split('0').filter { it != "" }.map { it.toLong() }
        val max = nums.maxOrNull() ?: 0L
        return nums.count { isPrime(it) }
    }
    
    private fun isPrime(num: Long): Boolean {
        if (num < 2) return false
        for (i in 2..Math.sqrt(num.toDouble()).toLong()) {
            if (num % i == 0L) return false
        }
        return true
    }
}
