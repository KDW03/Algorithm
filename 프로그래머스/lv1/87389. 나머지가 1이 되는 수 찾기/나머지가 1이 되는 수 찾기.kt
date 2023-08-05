class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 1
        
        while(true){
            
            if(n % answer == 1) return answer
            
            answer++
        }
        
        return answer
    }
}