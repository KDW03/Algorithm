import kotlin.math.*

class Solution {
    fun solution(n: Long): Long {

    var doubleN = n.toDouble()
    val sqrtN = sqrt(doubleN).toLong().toDouble()
    val nN = sqrtN.pow(2).toLong()
    
    return if(nN != n) -1 else {
            (sqrtN + 1).pow(2).toLong()
        }
    
    }        
}