class Solution {
    fun solution(storey: Int): Int {
        var pre = 0
        val str = storey.toString().reversed()
        var answer = 0
        
        for(i in str.indices) {
            val c = str[i]
            val num = c.digitToInt() + pre
            
            val next : Int? = if(i + 1 in str.indices) str[i + 1].digitToInt() else null
            
            
            when {
                num == 5 -> {
                    pre = if(next != null && next >= 5) {
                        1
                    }else {
                        0
                    }
                    answer += num 
                }
                
                num > 5 -> {
                    pre = 1
                    answer += (10 - num)
                    if(next == null) answer++
                }
                
                num < 5 -> {
                    pre = 0
                    answer += num
                }
            }
        }
        
        return answer
    }
}