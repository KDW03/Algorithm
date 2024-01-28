var answer = Int.MAX_VALUE
fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M, H) = br.readLine().split(" ").map { it.toInt() }
    val ladder = Array(H) { BooleanArray(N) { false } }

    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() - 1 }
        ladder[a][b] = true
    }

    addLadder(N, H, ladder, 0, 0)

    if (answer == Int.MAX_VALUE) answer = -1
    println(answer)
}


fun addLadder(n: Int, h: Int, ladder: Array<BooleanArray>, count: Int, start: Int) {
    if (count >= 4 || count >= answer) return
    if (checkLadder(n, h, ladder)) {
        answer = answer.coerceAtMost(count)
        return
    }

    for (i in start until h * (n - 1)) {
        val row = i / (n - 1)
        val col = i % (n - 1)

        if (!ladder[row][col] && !(col > 0 && ladder[row][col - 1]) && !(col < n - 2 && ladder[row][col + 1])) {
            ladder[row][col] = true
            addLadder(n, h, ladder, count + 1, i + 1)
            ladder[row][col] = false
        }

    }
}

fun checkLadder(n: Int, h: Int, ladder: Array<BooleanArray>): Boolean {
    for (start in 0 until n) {
        var line = start
        for (row in 0 until h) {
            if (line > 0 && ladder[row][line - 1]) {
                line -= 1
            } else if (line < n - 1 && ladder[row][line]) {
                line += 1
            }
        }
        if (line != start) return false
    }
    return true
}