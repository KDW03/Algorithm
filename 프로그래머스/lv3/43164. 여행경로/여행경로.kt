import java.util.*

class Solution {
    private val answerArr : ArrayList<String> = arrayListOf()
    fun solution(tickets: Array<Array<String>>): Array<String> {
        // 연결 그래프 만들고 dfs
        // 알파벳 순
        // 총 들려야하는 순서를 저장하는 배열
        val graph : HashMap<String,PriorityQueue<String>> = hashMapOf()
        for(ticket in tickets){
            val start = ticket[0]
            val end = ticket[1]
            if(graph[start] == null){
                graph[start] = PriorityQueue()
            }
            graph[start]!!.add(end)
        }

        dfs(graph,"ICN")

        return answerArr.toTypedArray()
    }

    private fun dfs(graph:  HashMap<String,PriorityQueue<String>>, start : String){
        if (graph[start] != null){
            while(graph[start]!!.isNotEmpty()){
                val tmp = graph[start]!!.poll()
                dfs(graph,tmp)
            }
        }
        answerArr.add(0,start)
    }
}