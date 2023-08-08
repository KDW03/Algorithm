import kotlin.math.*

class Solution {
    fun solution(left: Int, right: Int): Int {
        return (left .. right).map {
            isPlus(it)       
        }.sum()
    }
}

fun isPlus(num : Int) : Int {
    var count = 2
    val a = sqrt(num.toDouble()).toInt()
    for(i in 2 until a) if(num % i == 0) count += 2 
    if(num == a.toDouble().pow(2.0).toInt() && num % a == 0) count ++  
    return if(count % 2 == 0) num else -num
}