class Solution {
    fun solution(n: Int): Int = (1..n).first{ n % it == 1} 
}