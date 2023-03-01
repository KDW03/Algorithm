class Solution {
    fun solution(numbers: String): Int {
        val answer = mutableSetOf<Int>()
        val tmp = dfs(numbers,"",answer)
        
        return answer.size
    }
    

    fun dfs(numbers: String, current: String, answer: MutableSet<Int>) {
        if (current.isNotEmpty() && isSoSoo(current.toInt()))
            answer.add(current.toInt())
        
        if(numbers.isEmpty()) return
        
        for(i in numbers.indices){
            val remaining = numbers.substring(0,i) + numbers.substring(i+1)
            dfs(remaining, current+numbers[i], answer)
        }

    }
    
    
    fun isSoSoo(num : Int) : Boolean{
        if(num <= 1) return false
        if(num == 2) return true 
        if(num % 2 == 0) return false 
        for(i in 3..(Math.sqrt(num.toDouble())).toInt() step 2) {
            if(num % i == 0) return false 
        }
        return true
    }

    
}