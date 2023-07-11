class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> = strings.sorted().sortedBy { it[n] }.toTypedArray()
}