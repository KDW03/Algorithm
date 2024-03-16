fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val heights = br.readLine().split(" ").map { it.toLong() }
    val canSee = Array(n) { BooleanArray(n) }

    for (i in 0 until canSee.size - 1) {
        val iHeight = heights[i]
        // 초기 설정
        var maxDiffHeight = heights[i + 1] - iHeight  // a
        var maxDist = 1 // b
        canSee[i][i + 1] = true
        canSee[i + 1][i] = true

        for (j in i + 2 until canSee.size) {
            val jHeight = heights[j]
            val diff = jHeight - iHeight // c
            val dist = j - i // d
            val new = diff * maxDist
            if (new > maxDiffHeight * dist) {
                canSee[i][j] = true
                canSee[j][i] = true
                maxDiffHeight = diff
                maxDist = dist
            }
        }
    }

    println(canSee.maxOf { it.count { it } })
}