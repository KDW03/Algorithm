class Solution {
    fun solution(s: String): String {
        return s.split(" ").map { if(it.isBlank()) "" else it.first().uppercase() + it.drop(1).lowercase() }.joinToString(" ")
    }
}