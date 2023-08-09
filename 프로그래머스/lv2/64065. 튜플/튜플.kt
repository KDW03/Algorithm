class Solution {
    fun solution(s: String): IntArray =
        s.drop(2).dropLast(2).split("},{").sortedBy { it.length }.map { it.split(",").map { it.toInt() } }
            .fold(setOf<Int>()) { acc, ints ->
                acc.union(ints)
            }.toIntArray()
}