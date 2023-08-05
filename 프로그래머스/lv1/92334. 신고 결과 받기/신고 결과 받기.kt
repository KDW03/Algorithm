data class Info(val reportArray: ArrayList<String> = arrayListOf(), var reportCount: Int = 0)

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {

        val totalmap = id_list.associateWith { Info() }
        report.toSet().map { it.split(" ") }.forEach { list ->
            val p = list[0]
            (1 until list.size).forEach { index ->
                totalmap[list[index]]!!.reportCount++
                totalmap[p]!!.reportArray.add(list[index])
            }
        }
        
        return totalmap.map{ it.value.reportArray.count{ p -> totalmap[p]!!.reportCount >= k } }.toIntArray()
    }
}