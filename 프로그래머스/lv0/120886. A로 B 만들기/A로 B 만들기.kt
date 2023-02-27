class Solution {
    fun solution(before: String, after: String): Int{
        before.forEach{
            char ->
            if(before.count{it == char} != after.count{it == char}) return 0
        }
        return 1
    } 
}