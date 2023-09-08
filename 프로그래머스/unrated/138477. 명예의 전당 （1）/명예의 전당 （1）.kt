import java.util.*

class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        
        val answer = IntArray(score.size)
        
        val l = IntArray(k)
        
        score.forEachIndexed { index , v->
            
            if(index + 1 <= k){
                l[index] = v
                l.sortDescending()
                answer[index] = l[index]
            }else{
                if(l[k - 1] < v) {
                    l[k - 1] = v
                    l.sortDescending()
                }       
                answer[index] = l[k - 1]
            }
            
        }
        
        return answer
    }
}




