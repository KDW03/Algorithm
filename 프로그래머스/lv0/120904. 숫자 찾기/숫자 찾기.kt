class Solution {
    fun solution(num: Int, k: Int): Int {
        val str = num.toString()
        val result = str.indexOf(k.digitToChar())
        return if (result == -1) result else result+1
    }
}
