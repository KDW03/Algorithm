class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportSet = report.toSet()
        val map = reportSet.toList().groupingBy{ it.split(" ")[1] }.eachCount()
        val tmp = reportSet.groupBy { it.split(" ")[0] }

        return id_list.map { re ->
            tmp.getOrDefault(re, listOf()).count { map.getOrDefault(it.split(" ")[1],0) >= k }
        }.toIntArray()
    }
}