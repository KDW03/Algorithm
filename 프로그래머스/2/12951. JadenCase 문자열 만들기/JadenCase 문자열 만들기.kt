class Solution {
    fun solution(s: String): String {
        return s.split(" ").map { 
            if(!it.isEmpty() && !it.first().isDigit()) {
                it.first().uppercase() + it.drop(1).lowercase()
            }else {
                it.lowercase()
            }
        }.joinToString(" ")
    }
}