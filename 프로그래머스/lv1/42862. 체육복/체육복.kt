class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n - lost.size

        var mr = reserve.toMutableList()
        var ml = lost.toMutableList()
        
        lost.forEach {
            if (mr.remove(it)) {
                ml.remove(it)
                answer++
            }
        }
        
        ml.sorted().forEach {
            if (it - 1 > 0 && mr.remove(it - 1)) {
                answer++
            } else if (it + 1 <= n && mr.remove(it + 1)) {
                answer++
            }
        }

        return answer
    }
}
