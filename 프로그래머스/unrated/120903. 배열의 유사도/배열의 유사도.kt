class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int = s1.count { s2.contains(it) }
}