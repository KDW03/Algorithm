import java.util.*
class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val adj : Array<BooleanArray> = Array(n+1) { BooleanArray(n+1){false} } 
        for(result in results){
            val winner = result[0]
            val loster = result[1]
            adj[winner][loster] = true
        }
        
        for(k in 1 until n+1){
            for(i in 1 until n+1){
                for(j in 1 until n+1){
                    if(adj[i][k] && adj[k][j]) adj[i][j] = true
                }
            }
        }
        
        for(i in 1..n){
            var count = 0
            for(j in 1..n){
                if(adj[i][j] || adj[j][i]) count++
            }
            if(count >= n-1){
                answer++
            }
        }
        
        return answer
    }
}