import kotlin.math.*

class Solution {
    fun solution(n: Int): Int {
        val table : IntArray = IntArray(101)

        for(i in 1 until table.size) {
            table[i] = table[i-1] + isComposite(i)
        }

        return table[n]
    }


    fun isComposite(n : Int) : Int {
        
        for(i in 2 .. sqrt(n.toDouble()).toInt()) {
            if(n % i == 0) return 1
        }
        
        return 0
    }
}