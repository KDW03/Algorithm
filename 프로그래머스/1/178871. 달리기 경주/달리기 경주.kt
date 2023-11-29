class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val indexMap = players.withIndex().associate { it.value to it.index }.toMutableMap()

        callings.forEach {
            val i = indexMap[it] ?: return@forEach
            val j = i - 1
            overtaking(players, indexMap, i, j)
        }

        return players
    }

    fun overtaking(players: Array<String>, indexMap: MutableMap<String, Int>, i: Int, j: Int) {
        val temp = players[j]
        players[j] = players[i]
        players[i] = temp

        indexMap[players[j]] = j
        indexMap[players[i]] = i
    }
}

