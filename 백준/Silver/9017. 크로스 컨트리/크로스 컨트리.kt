fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    repeat(n) {
        val c = br.readLine().toInt()
        val countValueMap = hashMapOf<Int, Triple<Int, Int, Int>>()
        val result = br.readLine().split(" ").map { it.toInt() }
        val rankTeam = result.groupingBy { it }.eachCount().filter { it.value >= 6 }.keys
        var score = 0
        result.filter { rankTeam.contains(it) }.forEach {
            score++
            countValueMap[it] = countValueMap.getOrDefault(it, Triple(0, 0, Int.MAX_VALUE)).let { pre ->
                if (pre.first < 4) {
                    Triple(pre.first + 1, pre.second + score, Int.MAX_VALUE)
                } else if (pre.first == 4 && pre.third == Int.MAX_VALUE) {
                    Triple(pre.first, pre.second, score)
                } else {
                    pre
                }
            }
        }
        val s = countValueMap.toList().sortedWith(compareBy<Pair<Int, Triple<Int, Int, Int>>> { it.second.second }.thenBy { it.second.third })
        sb.append(s.first().first).append("\n")
    }
    print(sb.toString())
}