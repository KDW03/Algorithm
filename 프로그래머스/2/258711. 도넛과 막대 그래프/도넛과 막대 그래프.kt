import java.util.*

data class Node(val nodeNum : Int,val inList : ArrayList<Int> = arrayListOf() , val outList : ArrayList<Int> = arrayListOf(), var visited : Boolean = false)

class Solution {
    fun solution(edges: Array<IntArray>): IntArray {
        val degreeMap : HashMap<Int,Node> = hashMapOf()

        edges.forEach {
            val sNum = it[0]
            val eNum = it[1]
            if(degreeMap[sNum] == null) degreeMap[sNum] = Node(sNum)
            if(degreeMap[eNum] == null) degreeMap[eNum] = Node(eNum)
            degreeMap[sNum]!!.outList.add(eNum)
            degreeMap[eNum]!!.inList.add(sNum)
        }


        // findAddNode
        val addNode = degreeMap.values.first {
            it.outList.size >= 2 && it.inList.size == 0
        }


        val total = addNode.outList.size
        
        fun findType(i : Int) : Int {
            val nowNode = degreeMap[i]!!
            if(nowNode.visited) return 0
            
            nowNode.visited = true
            
            // 막대
            if(nowNode.outList.size == 0) {
                return 1
            }
            
            // 8자
            if(nowNode.inList.size >= 2 && nowNode.outList.size == 2) {
                return 2
            }
            
            for(to in nowNode.outList) {
                val type = findType(to)
                if(type != 0) return type
            }
            
            // 도넛
            return 0
        }
        
        var lineCount = 0
        var eightCount = 0
        
        for(to in addNode.outList) {    
            val type = findType(to)
            if(type == 1) lineCount++
            if(type == 2) eightCount++
        }
        
        return intArrayOf(addNode.nodeNum,total - (lineCount + eightCount), lineCount, eightCount)
    }
}