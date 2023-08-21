class Solution {
    fun solution(n: Int): Int = (1..n).fold(0){ acc,i -> if(n % i == 0) acc + i else acc }
}
