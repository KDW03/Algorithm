fun main() {
    val br = System.`in`.bufferedReader()
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(R) { br.readLine().map { it - 'A' } }
    val visited = BooleanArray('Z' - 'A' + 1)

    val start = Triple(0, 0, 1)
    var maxMove = 0
    visited[arr[0][0]] = true
    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)

    fun dfs(start: Triple<Int, Int, Int>) {
        val (x, y, dist) = start
        maxMove = maxOf(maxMove, dist)
        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]

            if (nx in 0 until R && ny in 0 until C) {
                val alphabet = arr[nx][ny]
                if (!visited[alphabet]) {
                    visited[alphabet] = true
                    dfs(Triple(nx, ny, dist + 1))
                    visited[alphabet] = false
                }
            }
        }
    }

    dfs(start)
    println(maxMove)
}