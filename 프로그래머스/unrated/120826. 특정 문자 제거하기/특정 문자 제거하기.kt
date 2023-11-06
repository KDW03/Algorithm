class Solution {
    fun solution(my_string: String, letter: String): String = my_string.filter{ it.toString() != letter }
}