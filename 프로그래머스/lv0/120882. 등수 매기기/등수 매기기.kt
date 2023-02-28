class Solution {
    fun solution(score: Array<IntArray>): IntArray {
        val sumList = score.map{ it.average() }
        return sumList.map{num -> sumList.count{ it > num } + 1  }.toIntArray()
    }
}