class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        val a = slicer[0]
        val b = slicer[1]
        val c = slicer[2]
        return when (n) {
            1 -> {
                num_list.sliceArray(0..b)
            }
            2 -> {
                num_list.sliceArray(a until num_list.size)
            }

            3 -> {
                num_list.sliceArray(a..b)
            }

            else -> {
                num_list.sliceArray(a..b).filterIndexed { index, i -> (index + 1) % c != 0 }.toIntArray()
            }
        }
    }
}