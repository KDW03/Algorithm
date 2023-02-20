class Solution {
    fun solution(my_string: String): String = my_string.lowercase().toCharArray().sorted().joinToString("")
}
