import java.util.LinkedList
import java.util.Queue

// x,y는 상어의 위치, s는 속력, d는 방향, z는 크기
data class Shark(val x: Int, val y: Int, val s: Int, val d: Int, val z: Int)

fun main() {

    val br = System.`in`.bufferedReader()
    val (r, c, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(r) {
        IntArray(c)
    }
    val xCycle = 2 * r - 2
    val yCycle = 2 * c - 2
    val sharkPosition: ArrayList<Shark> = ArrayList()

    repeat(m) {
        val (x, y, s, d, z) = br.readLine().split(" ").map { it.toInt() }
        board[x - 1][y - 1] = z
        sharkPosition.add(Shark(x - 1, y - 1, s, d - 1, z))
    }

    var answer = 0
    // 위 아래 오 왼
    val moveX = arrayOf(-1, 1, 0, 0)
    val moveY = arrayOf(0, 0, 1, -1)


    // 1. 사람 이동
    for (now in 0 until c) {

        var removeX = -1
        var removeY = -1


        // 2. now 위치에서 낚시 시작 0과 가장 가까운
        for (x in 0 until r) {
            if (board[x][now] != 0) {
                answer += board[x][now]
                removeX = x
                removeY = now
                break
            }
        }

        fun change(nd: Int): Int {
            return when (nd) {
                0 -> 1
                1 -> 0
                2 -> 3
                else -> 2
            }
        }

        // 3. 상어 이동
        // 상어 삭제
        for ((x, y, s, d, z) in sharkPosition) {
            board[x][y] = 0
        }

        // 상어 이동

        val newSharkPosition = ArrayList<Shark>()
        // z가 큰거부터
        for ((x, y, s, d, z) in sharkPosition.sortedByDescending { it.z }) {
            if (removeX == x && removeY == y) continue

            var nx = x
            var ny = y
            var nd = d

            val ns = if (d <= 1) s % xCycle else s % yCycle
            // s 만큼 이동
            repeat(ns) {
                nx += moveX[nd]
                ny += moveY[nd]

                if (nx !in board.indices || ny !in board[0].indices) {
                    nd = change(nd)
                    nx += moveX[nd] * 2
                    ny += moveY[nd] * 2
                }
            }

            // 현재 있는것보다 크다면
            if (z > board[nx][ny]) {
                board[nx][ny] = z
                newSharkPosition.add(Shark(nx, ny, s, nd, z))
            }

        }

        sharkPosition.clear()
        sharkPosition.addAll(newSharkPosition)
    }

    println(answer)
}