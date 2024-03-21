import java.util.*

class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        
        val graph = Array(n + 1) { IntArray(n + 1) { -1 } }
        
        for(i in 1 .. n) {
            graph[i][i] = 0
        }
        
        fares.forEach {
            val a = it[0]
            val b = it[1]
            val cost = it[2]
            graph[a][b] = cost
            graph[b][a] = cost
        }
        
        
        for(k in 1 .. n) {
            for(i in 1 .. n) {
                for(j in 1 .. n) {
                    if(i == j) continue
                    if(graph[i][k] == -1 || graph[k][j] == -1) continue
                    val newCost = graph[i][k] + graph[k][j]
                    if(graph[i][j] == -1) {
                        graph[i][j] = newCost                    
                    } else { 
                        graph[i][j] = minOf(graph[i][j],newCost)
                    }
                }
            }
        }
        
        var answer = Int.MAX_VALUE
        for(k in 1 .. n) {
            if(graph[a][k] == -1 || graph[b][k] == -1 || graph[s][k] == -1) continue
            answer = minOf(answer,graph[a][k] + graph[b][k] + graph[s][k])
        }
        
        return answer
    }
}