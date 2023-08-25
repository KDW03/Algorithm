class Solution {
    fun solution(a: Int, b: Int): Long = if(b>a) (a..b).sumOf { it.toLong() } else (b..a).sumOf{ it.toLong( )}
}