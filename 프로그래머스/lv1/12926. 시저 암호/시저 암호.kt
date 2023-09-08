class Solution {
    fun solution(s: String, n: Int): String {
        
        val len = 'Z' - 'A' + 1
        return s.map { 
            
            when(it) {
                in 'a'..'z' -> {
                     'a' + (it + n - 'a') % len 
                }
                
                in 'A'..'Z' -> {
                    'A' + (it + n - 'A') % len
                }
                
                else -> {
                    it
                }
            }
        }.joinToString("")
        
    }
}