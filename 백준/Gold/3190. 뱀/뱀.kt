import java.util.Deque
import java.util.LinkedList
import java.util.Queue

enum class Direction {
    R, D, L, U
}

data class Position(val x: Int, val y: Int)

val moveX = arrayOf(0, 1, 0, -1)
val moveY = arrayOf(1, 0, -1, 0)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()

    // 없으면 0
    // 사과 1
    // 뱀 2
    val board = Array(n) { IntArray(n) }
    repeat(k) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() - 1 }
        board[x][y] = 1
    }

    // 시작 위치
    board[0][0] = 2

    val positionQueue: Deque<Position> = LinkedList()
    positionQueue.add(Position(0, 0))
    var nowTime = 0

    // 방향 변환 정보
    val l = br.readLine().toInt()
    var dirIdx = 0
    var dir = Direction.values()[dirIdx]
    repeat(l) {
        val (time, cmd) = br.readLine().split(" ")
        val remainTime = time.toInt() - nowTime
        val result = moveBeforeTime(board, positionQueue, remainTime, dir)
        if (result < remainTime) {
            println(nowTime + result + 1)
            return
        }
        nowTime += remainTime
        if (cmd == "D") {
            dirIdx++
            if (dirIdx > 3) dirIdx = 0
        } else {
            dirIdx--
            if (dirIdx < 0) dirIdx = 3
        }
        dir = Direction.values()[dirIdx]
    }

    val result = moveBeforeTime(board, positionQueue, 100, dir)
    println(nowTime + result + 1)
}



fun moveBeforeTime(board: Array<IntArray>, nowPosition: Queue<Position>, time: Int, dir: Direction): Int {
    val idx = Direction.values().indexOf(dir)
    repeat(time) { t ->
        val head = nowPosition.last()

        val nx = head.x + moveX[idx]
        val ny = head.y + moveY[idx]

        if (!(nx in board.indices && ny in board[0].indices)) return t

        when (board[nx][ny]) {
            0 -> {
                val remove = nowPosition.poll()
                board[remove.x][remove.y] = 0
                nowPosition.add(Position(nx, ny))
                board[nx][ny] = 2
            }
            1 -> {
                nowPosition.add(Position(nx, ny))
                board[nx][ny] = 2
            }

            else -> return t
        }
    }
    return time
}