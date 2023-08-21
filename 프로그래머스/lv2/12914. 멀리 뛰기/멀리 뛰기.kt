class Solution {
    
    fun solution(n: Int): Long {
        var dp = LongArray(2001)
        dp[1] = 1L
        dp[2] = 2L

        for(i in 3 .. 2000) dp[i] = (dp[i-1] + dp[i-2]) % 1234567 
        

        return dp[n]
    }

    
}