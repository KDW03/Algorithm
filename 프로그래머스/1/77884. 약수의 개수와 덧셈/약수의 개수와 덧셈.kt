import kotlin.math.*

class Solution {
    fun solution(left: Int, right: Int): Int {    
        var sum = 0
        for(num in left .. right) {
            sum = sum + if(isPlus(num)) num else -num
        }
        
        return sum
    }
    
    
    fun isPlus(num : Int) : Boolean {
        
        var count = 0
        
        val sqrt = sqrt(num.toDouble()).toInt()
        
        if(sqrt * sqrt == num) count--
        for(i in 2 .. sqrt)  {
            if(num % i == 0) { 
                count += 2
            }
        }
        
        return count % 2 == 0
    }
    
}