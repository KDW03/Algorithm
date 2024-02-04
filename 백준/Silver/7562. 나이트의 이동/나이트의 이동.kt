import java.util.LinkedList
import java.util.Queue

data class Position(val x: Int, val y: Int, val dist: Int)

val moveX = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)
val moveY = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)


fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val visited = Array(n) { BooleanArray(n) }
        val (startX, startY) = br.readLine().split(" ").map { it.toInt() }
        val (destX, destY) = br.readLine().split(" ").map { it.toInt() }
        val startPosition = Position(startX, startY, 0)
        val destPosition = Position(destX, destY, 0)
        val q: Queue<Position> = LinkedList()
        q.add(startPosition)
        visited[startX][startY] = true
        while (q.isNotEmpty()) {
            val nowPosition = q.poll()
            if (nowPosition.x == destPosition.x && nowPosition.y == destPosition.y) {
                println(nowPosition.dist)
                break
            }
            val (x, y, dist) = nowPosition
            for (i in moveX.indices) {
                val nx = x + moveX[i]
                val ny = y + moveY[i]
                if (nx in visited.indices && ny in visited[0].indices && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    q.add(Position(nx, ny, dist + 1))
                }
            }
        }
    }
}
