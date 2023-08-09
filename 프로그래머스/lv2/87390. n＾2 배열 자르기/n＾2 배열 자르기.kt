class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val result = IntArray((right - left + 1).toInt())
        for (i in left..right) {
            val y = (i / n).toInt()
            val x = (i % n).toInt()
            result[(i - left).toInt()] = maxOf(x + 1, y + 1)
        }
        return result
    }
}
