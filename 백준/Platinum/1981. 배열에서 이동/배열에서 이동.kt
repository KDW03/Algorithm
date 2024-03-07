import java.util.LinkedList
import java.util.Queue


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() } }

    var start = 0
    var end = 200

    while (start <= end) {
        val maxDiff = (start + end) / 2
        // 이 거리로 가진다면
        if (isPathPossible(board, maxDiff)) {
            end = maxDiff - 1
        } else {
            start = maxDiff + 1
        }

    }

    println(start)
}

fun isPathPossible(board: Array<List<Int>>, maxDiff: Int): Boolean {
    for (startValue in 0..200) {
        // startValue, startValue + maxDiff에 포함된 값으로만 가능한지
        if (bfs(board, startValue, startValue + maxDiff)) {
            return true
        }
    }
    return false
}

fun bfs(board: Array<List<Int>>, min: Int, max: Int): Boolean {
    if (board[0][0] !in min..max) return false

    val n = board.size
    val visited = Array(n) { BooleanArray(n) }

    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)
    val range = 0 until n
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(0, 0))
    visited[0][0] = true

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        if (x == n - 1 && y == n - 1) return true

        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]

            if (nx in range && ny in range && !visited[nx][ny] && board[nx][ny] in min..max) {
                visited[nx][ny] = true
                q.add(Pair(nx,ny))
            }
        }
    }
    return false
}
