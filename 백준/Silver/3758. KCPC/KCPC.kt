data class Team(
    val id: Int, val scoreMap: MutableMap<Int, Int> = mutableMapOf(),
    var submitCount: Int = 0, var lastSubmit: Int = 0
) {
    fun submit(j: Int, s: Int, idx: Int) {
        scoreMap[j] = maxOf(scoreMap.getOrDefault(j, 0), s)
        submitCount++
        lastSubmit = idx
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val tc = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(tc) {
        // 팀의 개수 n, 문제의 개수 k, 당신 팀의 ID t, 로그 엔트리의 개수 m
        val (n, k, t, m) = br.readLine().split(" ").map { it.toInt() }
        val teams = Array(n) { Team(it + 1) }

        repeat(m) { idx ->
            // 팀 ID i, 문제 번호 j, 획득한 점수 s
            val (i, j, s) = br.readLine().split(" ").map { it.toInt() }
            teams[i - 1].submit(j, s, idx)
        }

        teams.sortWith(
            compareByDescending<Team>{ it.scoreMap.values.sum() }.thenBy { it.submitCount }.thenBy { it.lastSubmit }
        )

        val rank = teams.indexOfFirst { it.id == t }
        sb.append(rank + 1).append("\n")
    }

    print(sb.toString())
}