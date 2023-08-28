class Solution {
    fun solution(number: IntArray): Int {
        var answer: Int = 0
        val size = number.size
        
        for(i in 0 until size - 2) {
            for(j in i + 1 until size - 1) {
                for(k in j + 1 until size) {
                    if(number[i] + number[j] + number[k] == 0){
                        answer++
                    } 
                }
            }
        }
               
        return answer
    }
}