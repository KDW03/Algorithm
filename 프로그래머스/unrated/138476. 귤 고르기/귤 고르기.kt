class Solution {
    fun solution(k: Int, tangerine: IntArray): Int = tangerine.toList().groupingBy { it }.eachCount().toList().sortedByDescending { it.second }
            .fold(Pair(0, 0)) { acc, pair -> if (acc.second >= k) acc else Pair(acc.first + 1, acc.second + pair.second) }.first
}


// 