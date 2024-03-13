data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val visited = Array(n) { BooleanArray(n) }
    val canGo = Array(n) { LongArray(n) }

    val start = Point(0, 0)
    val end = Point(n - 1, n - 1)
    val moveX = arrayOf(0, 1)
    val moveY = arrayOf(1, 0)

    fun dfs(s: Point): Long {
        if (s == end) return 1L
        val (x, y) = s
        visited[x][y] = true
        val moveCount = arr[x][y]
        for (dir in 0 until 2) {
            val moveXCount  = moveX[dir] * moveCount
            val moveYCount  = moveY[dir] * moveCount

            val nx = x + moveXCount
            val ny = y + moveYCount

            if (nx in arr.indices && ny in arr[0].indices) {
                if (!visited[nx][ny]) {
                    val result = dfs(Point(nx, ny))
                    if (result >= 1) canGo[x][y] += result
                } else {
                    canGo[x][y] += canGo[nx][ny]
                }
            }
        }

        return canGo[x][y]
    }

    dfs(start)
    println(canGo.first().first())
}