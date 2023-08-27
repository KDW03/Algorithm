class Solution {
    fun solution(my_string: String): IntArray = my_string.filter{ it.isDigit() }.map{ it.digitToInt() }.sorted().toIntArray()
}