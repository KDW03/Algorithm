class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val keyLeastMap = mutableMapOf<Char, Int>()

        keymap.forEach { key ->
            key.forEachIndexed { index, char ->
                keyLeastMap[char] = keyLeastMap.getOrDefault(char, index + 1).coerceAtMost(index + 1)
            }
        }

        return targets.map { target ->
            target.sumOf { char ->
                keyLeastMap[char] ?: return@map -1
            }
        }.toIntArray()
    }
}
