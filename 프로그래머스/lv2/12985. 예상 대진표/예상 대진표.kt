import kotlin.math.*

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var va = a
        var vb = b
        
        while(true){
            va = (va / 2) + (va % 2)
            vb = (vb / 2) + (vb % 2)
            answer++
            if(va==vb) break;
        }
        
        return answer
    }
}