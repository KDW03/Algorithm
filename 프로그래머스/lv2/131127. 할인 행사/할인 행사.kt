class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var start = 0
        var end = 9

        val countMap: HashMap<String, Int> = hashMapOf()

        for (i in want.indices) {
            countMap[want[i]] = number[i]
        }

        var answer = 0

        outer@ while (end < discount.size) {
            val haveMap: Map<String, Int> = discount.slice(start..end).toList().groupingBy { it }.eachCount()
            for ((k, v) in countMap) {
                if (haveMap[k] == null || haveMap[k]!! < v) {
                    end = discount.indexOfFrom(end + 1, k)
                    if (end == Int.MAX_VALUE) break@outer
                    start = end - 9
                    continue@outer
                }
            }
            end = discount.indexOfFrom(end + 1, discount[start])
            start = end - 9
            answer++
        }
        return answer
    }

    private fun <T> Array<T>.indexOfFrom(start: Int, element: T): Int {
        for (i in start until this.size) {
            if (this[i] == element) return i
        }
        return Int.MAX_VALUE
    }
}