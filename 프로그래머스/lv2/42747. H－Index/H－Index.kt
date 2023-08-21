class Solution {
    fun solution(citations: IntArray): Int {
        val max = citations.maxOf { it }
        val countArray = IntArray(max + 1)

        for (cita in citations) countArray[cita]++

        val accArray = IntArray(max + 1)
        accArray[max] = countArray[max]

        // k 는 k+1 번째 개수 합 + k 번째 개수
        for (k in accArray.size - 2 downTo 0) accArray[k] = accArray[k + 1] + countArray[k]

        for(h in accArray.size - 1 downTo 0) {
            if(h <= accArray[h]) return h
        }

        return 0
    }
}
