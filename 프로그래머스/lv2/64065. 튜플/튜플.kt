import java.util.TreeSet

class Solution {
    fun solution(s: String): IntArray {
        // 첫 {{}} 제거
        val list : MutableList<Int> = mutableListOf()
        val t =  s.drop(2).dropLast(2)
        // },{ 로 구분
        t.split("},{").sortedBy{ it.length }.map{ it.split(",").map { it.toInt() } }.forEach {
            it.forEach {
                if(!list.contains(it)){
                    list.add(it)                
                }
            }
        }

        return list.toIntArray()
    }
}