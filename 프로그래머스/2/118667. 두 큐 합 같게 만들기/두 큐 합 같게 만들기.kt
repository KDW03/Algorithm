import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        
        val aList = queue1.map{ it.toLong() }
        val bList = queue2.map{ it.toLong() }
        var aSum = aList.sumOf{ it }
        var bSum = bList.sumOf{ it }
        
        val total : Long = aSum + bSum
        if(total % 2  == 1L) return -1
        
        val aQ : Queue<Long> = LinkedList(aList)
        val bQ : Queue<Long> = LinkedList(bList)
        
        var count = 0
        
        while(true) {
            
            if(count >= 700000) return -1
            
            if(aSum == bSum) break
            
            if(aSum > bSum) {
                val aP = aQ.poll()
                bQ.add(aP)
                aSum -= aP
                bSum += aP
            } else {
                val bP = bQ.poll()
                aQ.add(bP)
                aSum += bP
                bSum -= bP
            }
            
            count++
        }
        
        return count
        
    }
}