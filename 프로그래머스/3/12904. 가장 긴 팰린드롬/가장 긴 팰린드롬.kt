class Solution {
    fun solution(s: String): Int {
        val n = s.length
        val dp = Array(n) {  BooleanArray(n) }
        
        var answer = 1
        
        for(i in 0 until n) {
            dp[i][i] = true
        }
        
        for(i in 0 until n - 1) {
            if(s[i] == s[i + 1]) {
                dp[i][i+1] = true
                answer = 2
            }
        }
        

        for(len in 3 .. n) {
            for(start in 0 .. n - len) {
                val end = start + len - 1
                if(s[start] == s[end] && dp[start + 1][end - 1]) {
                    answer = len
                    dp[start][end] = true
                }
            }
        }
        
        
        return answer
    }
}