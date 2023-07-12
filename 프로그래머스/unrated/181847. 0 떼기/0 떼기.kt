class Solution {
    fun solution(n_str: String): String = n_str.substring(n_str.indexOfFirst { it != '0' })
}