import java.util.LinkedList
import java.util.Queue

class Solution {
        fun solution(board: Array<IntArray>): Int {
        val N = board.size
        val costs = Array(N) { Array(N) { IntArray(4) { Int.MAX_VALUE } } }
        val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

        val queue: Queue<IntArray> = LinkedList()
        queue.add(intArrayOf(0, 0, -1, 0))  // x, y, direction, cost

        while (queue.isNotEmpty()) {
            val (x, y, prevD, cost) = queue.poll()

            for (d in directions.indices) {
                val (dx, dy) = directions[d]
                val nx = x + dx
                val ny = y + dy

                if (nx in 0 until N && ny in 0 until N && board[nx][ny] == 0) {
                    val newCost = if (d == prevD || prevD == -1) cost + 100 else cost + 600

                    if (costs[nx][ny][d] > newCost) {
                        costs[nx][ny][d] = newCost
                        queue.add(intArrayOf(nx, ny, d, newCost))
                    }
                }
            }
        }

        return costs[N - 1][N - 1].minOrNull() ?: 0
    }
}