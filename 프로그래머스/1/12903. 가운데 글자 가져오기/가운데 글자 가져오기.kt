class Solution {
    fun solution(s: String): String {
        val mid = s.length / 2
        return if(s.length % 2 == 1) "${s[mid]}" else "${s[mid - 1]}${s[mid]}"
    }
}