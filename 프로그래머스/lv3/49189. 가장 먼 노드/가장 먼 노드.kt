import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        val dkTable = IntArray(n+1){ Int.MAX_VALUE }
        dkTable[0] = 0
        val graph : Array<ArrayList<Int>> = Array(n+1){ arrayListOf() }
        for(i in edge){
            val start = i[0]
            val end = i[1]
            graph[start].add(end)
            graph[end].add(start)
        }
        dkStra(graph,dkTable,1)
  
        return dkTable.count{ it == dkTable.maxOrNull()!! }
    }
    
    fun dkStra(graph : Array<ArrayList<Int>>, dkTable : IntArray, start : Int){
        val q : Queue<Int> = LinkedList()
        q.add(start)
        dkTable[start] = 0
        while(q.isNotEmpty()){         
            val now = q.poll()
            for(dest in graph[now]){
                if(dkTable[dest] > dkTable[now] + 1){
                    dkTable[dest] = dkTable[now] + 1  
                    q.add(dest)
                }
            }
        }
    }
}