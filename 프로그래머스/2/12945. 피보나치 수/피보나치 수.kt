class Solution {
    fun solution(n: Int): Int {
        val dp = IntArray(n + 1) { -1 }
        dp[0] = 0
        dp[1] = 1
        return fibo(n,dp)
    }
    
    
    fun fibo(n : Int, dp : IntArray) : Int {
        if(dp[n] == -1) dp[n] = (fibo(n - 1,dp) + fibo(n - 2,dp)) % 1234567
        return dp[n]
    }
    
}