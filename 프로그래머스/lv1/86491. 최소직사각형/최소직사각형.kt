class Solution {
    fun solution(sizes: Array<IntArray>): Int = sizes.map{ it.maxOrNull()!! }.maxOrNull()!! * sizes.map{ it.minOrNull()!! }.maxOrNull()!!
}