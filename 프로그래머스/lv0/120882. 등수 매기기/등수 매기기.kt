class Solution {
    fun solution(score: Array<IntArray>): IntArray {
        val sumList = score.map{ it[0] + it[1] }
        val sumSortList = sumList.sorted().reversed()
        return sumList.map{ sumSortList.indexOf(it)+1 }.toIntArray()
    }
}