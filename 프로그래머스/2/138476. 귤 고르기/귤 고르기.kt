class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        
        val sortedValue = tangerine.toList().groupingBy { it }.eachCount()
            .toList().sortedByDescending{ it.second }
        
        var sum = 0
        var count = 0
        for((key,value) in sortedValue) {
            sum += value
            count++
            if(sum >= k) break
        }
        
        return count
    }
}