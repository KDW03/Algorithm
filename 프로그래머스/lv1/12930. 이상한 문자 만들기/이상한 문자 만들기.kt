class Solution {
    fun solution(s: String): String {
        var count = 0
        return s.map{ 
            v -> if(v == ' ') {
                count = 0
                ' '
            }else{
                if(count++ % 2 == 0) v.uppercase()
                else v.lowercase() 
            }
        }.joinToString("")
    }
}