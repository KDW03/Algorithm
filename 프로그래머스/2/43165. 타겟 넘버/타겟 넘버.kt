class Solution {
    fun solution(numbers: IntArray, target: Int): Int = dfs(numbers,target)    
    // 2 ^ n
    // 2 ^ 20
    fun dfs(numbers: IntArray, target: Int, i : Int = 0 , sum : Int = 0) : Int {
        if(numbers.size == i) {
            if(sum == target) return 1
            return 0
        }
        var count = 0
        val now = numbers[i]
        count += dfs(numbers,target,i + 1, sum + now)
        count += dfs(numbers,target,i + 1, sum - now)
        return count
    }
    
}