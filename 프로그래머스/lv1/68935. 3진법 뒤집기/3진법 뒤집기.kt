import kotlin.math.*

class Solution {
    fun solution(n: Int): Int {
        val sb = StringBuilder()
        var s = n
        var result = 0.0
        while(s > 0){
            sb.append(s % 3)
            s /= 3
        }
        val t = sb.toString()
        t.mapIndexed { i , v -> 
            val digit = t.length - i - 1
            result += (3.0.pow(digit) * v.toString().toDouble())
        }        
        return result.toInt()
    }
}
