import java.util.*

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val graph : HashMap<String,ArrayList<String>> = hashMapOf()
        
        fun diffCount(a : String , b : String) : Int {
            var count = 0
            for(i in a.indices) {
                if(a[i] != b[i]) count++
                if(count >= 2) return count
            }
            return count
        }
        
        words.forEach { word ->
            words.forEach { dWord ->
                if(diffCount(word,dWord) == 1) {
                    if(graph[word] == null) graph[word] = arrayListOf()
                    graph[word]!!.add(dWord)
                    if(graph[dWord] == null) graph[dWord] = arrayListOf()
                    graph[dWord]!!.add(word)
                }
            }
        }
        
        // begin에서 갈 수 있는 그래프 형성
        words.forEach { word ->
            if(diffCount(word,begin) == 1) {
                if(graph[begin] == null) graph[begin] = arrayListOf()
                graph[begin]!!.add(word)
            }
        }
        
        fun bfs(start : String, target : String) : Int {
            val q : Queue<Pair<String,Int>> = LinkedList()
            val visited = BooleanArray(words.size)
            q.add(Pair(start,0))
            
            while(q.isNotEmpty()) {
                val (str,cost) = q.poll()
                if(str == target) return cost
                for(nb in graph.getOrDefault(str,arrayListOf())) {
                    val idx = words.indexOf(nb)
                    if(!visited[idx]) {
                        visited[idx] = true
                        q.add(Pair(nb,cost + 1))
                    }
                }
            }
            return 0
        }
        
        return bfs(begin,target)
    }
}

