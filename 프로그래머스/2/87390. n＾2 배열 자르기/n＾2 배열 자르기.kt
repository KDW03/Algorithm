class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = ArrayList<Int>()
        for(i in left .. right) {
            val x = (i / n).toInt()
            val y = (i % n).toInt()
            answer.add(maxOf(x + 1,y + 1))
        }
        return answer.toIntArray()
    }
}
