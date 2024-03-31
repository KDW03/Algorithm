import java.util.*
import kotlin.collections.ArrayList

// →, ←, ↑, ↓
val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(1, -1, 0, 0)

data class Piece(val idx: Int, var x: Int, var y: Int, var dir: Int) {

    fun move(boardColor: Array<IntArray>, board: Array<Array<Stack<Int>>>, pieces: Array<Piece>): Boolean {
        val nx = x + moveX[dir]
        val ny = y + moveY[dir]

        if (nx in boardColor.indices && ny in boardColor.indices && boardColor[nx][ny] != 2) {
            val tmp = ArrayList<Int>()

            // 만약 idx에 일치하는거 나올때까지
            while (board[x][y].isNotEmpty()) {
                val id = board[x][y].pop()
                tmp.add(id)
                if (id == idx) break
            }

            if (boardColor[nx][ny] == 0) {
                for (id in tmp.reversed()) {
                    pieces[id].x = nx
                    pieces[id].y = ny
                    board[nx][ny].add(id)
                }
            } else {
                // 빨간색 뒤집기
                for (id in tmp) {
                    pieces[id].x = nx
                    pieces[id].y = ny
                    board[nx][ny].add(id)
                }
            }
            if (board[nx][ny].size >= 4) return false
        } else {
            // 범위에 벗어나거나 파란색이라면
            // 방향 바꿔서 가보기
            changeDir()

            val nnx = x + moveX[dir]
            val nny = y + moveY[dir]

            if (nnx in boardColor.indices && nny in boardColor.indices && boardColor[nnx][nny] != 2) {
                return move(boardColor, board, pieces)
            }
        }
        return true
    }

    private fun changeDir() {
        dir = when (dir) {
            0 -> 1
            1 -> 0
            2 -> 3
            else -> 2
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()

    // N 체스판 크기, K 말의 개수
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    // 0은 흰색, 1은 빨간색, 2는 파란색
    var boardColor: Array<IntArray> = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val board: Array<Array<Stack<Int>>> = Array(n) { Array(n) { Stack<Int>() } }
    val pieces: Array<Piece> = Array(k) { idx ->
        val (x, y, dir) = br.readLine().split(" ").map { it.toInt() - 1 }
        // 스택에 넣기
        board[x][y].add(idx)
        // 돌아가면서 해당 위치에 나올때
        Piece(idx, x, y, dir)
    }

    var turnCount = 1
    outer@while (turnCount <= 1000) {
        for (p in pieces) {
            if (!p.move(boardColor,board,pieces)) break@outer
        }

        turnCount++
    }

    if (turnCount > 1000) {
        println(-1)
    } else {
        println(turnCount)
    }
}