import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val board = Array(m) { BooleanArray(n) }
        val visited = Array(m) { BooleanArray(n) }
        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            board[x][y] = true
        }
        val dx = arrayOf(0, 0, 1, -1)
        val dy = arrayOf(1, -1, 0, 0)
        var count = 0
        for (x in 0 until m) {
            for (y in 0 until n) {
                if (!visited[x][y] && board[x][y]) {
                    bfs(x, y, board, visited, m, n, dx, dy)
                    count++
                }
            }
        }
        println(count)
    }
}

fun bfs(x: Int, y: Int, board: Array<BooleanArray>, visited: Array<BooleanArray>, m: Int, n: Int, dx: Array<Int>, dy: Array<Int>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(x, y))
    visited[x][y] = true
    while (q.isNotEmpty()) {
        val (cx, cy) = q.poll()
        for (i in 0..3) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]
            if (nx in 0 until m && ny in 0 until n && !visited[nx][ny] && board[nx][ny]) {
                q.add(Pair(nx, ny))
                visited[nx][ny] = true
            }
        }
    }
}


