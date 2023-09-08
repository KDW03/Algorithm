class Solution {
    fun solution(s: String): Boolean {
        val len = s.length
        return s.all{ it.isDigit() } && (len == 4 || len == 6)
    }
}