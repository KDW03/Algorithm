
class Solution {
    fun solution(relation: Array<Array<String>>): Int {
        val cols = relation[0].size
        val rows = relation.size
        val candidates = mutableListOf<Set<Int>>()

        // 모든 키 조합을 만듬
        for (i in 1..cols) candidates.addAll(generateCombination(cols, i))

        val answer = mutableListOf<Set<Int>>()

        // 키 후보를 하나씩 꺼내서
        for (keys in candidates) {
            val uniqueCheck = mutableSetOf<String>()

            // 그 row를 하나씩 보면서
            for (r in 0 until rows) {
                // 각 키의 값을 합친게 유일한지
                val keyString = keys.joinToString(",") { relation[r][it] }
                uniqueCheck.add(keyString)
            }

            // 유일성이 검증됐다면
            if (uniqueCheck.size == rows) {
                // 최소성 검사
                var isMinimal = true

                // 정답을 보면서
                for (ans in answer) {
                    // 현재 유일성 중에 이전에 나온게 있다면 최소성 x
                    if (keys.containsAll(ans)) {
                        isMinimal = false
                        break
                    }
                }
                // 만약 이게 최소성 또한 만족이 되었다면
                if (isMinimal) answer.add(keys)
            }
        }
        return answer.size
    }

    private fun generateCombination(n: Int, r: Int): List<Set<Int>> {
        val results = mutableListOf<Set<Int>>()
        fun combination(arr: List<Int>, depth: Int, idx: Int, current: Set<Int>) {
            if (depth == r) {
                results.add(current.toSet())
                return
            }

            if (idx == n) return

            combination(arr, depth + 1, idx + 1, current + arr[idx])
            combination(arr, depth, idx + 1, current)
        }
        combination((0 until n).toList(), 0, 0, setOf())
        return results
    }
}