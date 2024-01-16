fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val board = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toMutableList()
    }

    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)

    // visited는 true이면 공기 false이면 치즈이거나 치즈에 갇힌 공기
    // checkChees는 공기와 접촉해있는 가장자리 치즈 검사 필요
    fun findAirArr(
        x: Int,
        y: Int,
        visited: Array<BooleanArray> = Array(n) { BooleanArray(m) },
        checkCheese: ArrayList<Pair<Int, Int>> = ArrayList()
    ): Pair<Array<BooleanArray>, ArrayList<Pair<Int, Int>>> {
        visited[x][y] = true
        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]
            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny]) {
                if (board[nx][ny] == 1) {
                    checkCheese.add(Pair(nx, ny))
                } else {
                    findAirArr(nx, ny, visited, checkCheese)
                }
            }
        }
        return Pair(visited, checkCheese)
    }

    var day = 0
    while (true) {
        val (visited, checkCheese) = findAirArr(0, 0)
        if (checkCheese.size == 0) break

        for ((x, y) in checkCheese) {
            var count = 0
            for (i in 0 until 4) {
                val nx = x + moveX[i]
                val ny = y + moveY[i]
                if (visited[nx][ny]) count++
            }
            if (count >= 2) board[x][y] = 0
        }

        day++
    }

    println(day)
}