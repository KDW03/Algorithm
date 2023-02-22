import java.util.*

class Solution {
    fun solution(n: Int): IntArray {
        val al : HashSet<Int> = hashSetOf()
        val sqr = Math.sqrt(n.toDouble()).toInt()
        for(i in 1 ..sqr){
            if(n % i == 0){
                al.add(i)
                al.add(n/i)
            }
        }
        return al.toIntArray().sortedArray()
    }
}