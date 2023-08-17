class Solution {
    var max = 1
    var answer: IntArray = intArrayOf()

    fun solution(n: Int, info: IntArray): IntArray {
        dfs(info.reversedArray(),n)
        return if(answer.isEmpty()) intArrayOf(-1) else answer
    }

    private fun dfs(info: IntArray, n: Int, idx: Int = 1, k: Int = 0, list: IntArray = IntArray(info.size)) {
        if (k > n) return
        if (k == n || idx == info.size) {
            val lionsum = list.foldIndexed(0) { i, s, acc -> s + if (acc != 0) i else 0 }
            val apeachsum = info.foldIndexed(0) { i, s, acc -> s + if (list[i] == 0 && acc != 0) i else 0 }
            if (lionsum - apeachsum >= max) {
                max = lionsum - apeachsum
                answer = list.reversedArray().apply { set(idx - 1, n - k) }
            }
            return
        }
        dfs(info, n, idx + 1, k, list)
        dfs(info, n, idx + 1, k + info[idx] + 1, list.copyOf().apply { set(idx, info[idx] + 1) })
    }

}

