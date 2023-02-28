import java.util.*

class Solution {
    fun solution(numlist: IntArray, n: Int): IntArray {
        
        numlist.sortDescending()
        
        return numlist.sortedBy{ Math.abs(it - n) }.toIntArray()
    }
}