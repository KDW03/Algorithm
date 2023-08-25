class Solution {
    fun solution(s: String): String = (
            s.toCharArray().filter {
                it.isLowerCase()
            }.sortedDescending()
                    + s.toCharArray().filter {
                it.isUpperCase()
            }.sortedDescending()
            ).joinToString("")
}