import kotlin.math.*

class Solution {
    fun solution(nums: IntArray): Int = check(nums)   
}


fun check(nums : IntArray) : Int {
    val size = nums.size
    var result = 0
    for(i in 0 until size - 2) {
        for(j in i + 1 until size - 1){
            outer@for(k in j + 1 until size){
                val sum = nums[i] + nums[j] + nums[k]
                for(z in 2 .. sqrt(sum.toDouble()).toInt()){
                    if(sum % z == 0) continue@outer;
                }
                result++
            }
        }
    }
    return result
}