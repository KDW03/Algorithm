import java.util.*
import kotlin.collections.ArrayList

data class Point(val x: Int, val y: Int)
data class Card(val num: Int, val point: Point)

class Solution {
    fun solution(board: Array<IntArray>, r: Int, c: Int): Int {

        val arrays = ArrayList<Card>()

        board.forEachIndexed { x, v ->
            v.forEachIndexed { y, c ->
                if (c != 0) {
                    arrays.add(Card(c, Point(x, y)))
                }
            }
        }

        val moveX = arrayOf(0, 0, 1, -1)
        val moveY = arrayOf(1, -1, 0, 0)

        fun bfs(find: Point, nowP: Point): Int {
            val q: Queue<Pair<Point, Int>> = LinkedList()
            val visited = Array(board.size) { BooleanArray(board[0].size) }
            q.add(Pair(nowP, 0))
            visited[nowP.x][nowP.y] = true

            while (q.isNotEmpty()) {
                val (p, cost) = q.poll()

                if (find == p) {
                    // + enter
                    return cost + 1
                }

                for (i in 0 until 4) {
                    var nx = p.x + moveX[i]
                    var ny = p.y + moveY[i]

                    // 이동
                    if (nx in board.indices && ny in board[0].indices && !visited[nx][ny]) {
                        visited[nx][ny] = true
                        q.add(Pair(Point(nx, ny), cost + 1))
                    }

                    // ctrl 이동
                    while (nx in board.indices && ny in board[0].indices && board[nx][ny] == 0) {
                        nx += moveX[i]
                        ny += moveY[i]
                    }

                    // 범위초과했으면 롤백
                    if (nx !in board.indices || ny !in board[0].indices) {
                        nx -= moveX[i]
                        ny -= moveY[i]
                    }

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true
                        q.add(Pair(Point(nx, ny), cost + 1))
                    }
                }
            }
            return -1
        }

        var answer = Int.MAX_VALUE

        fun makeCombi(
            group: List<Pair<Int, List<Card>>>,
            now: Array<Card> = arrayOf(),
            visited: BooleanArray = BooleanArray(9)
        ) {
            if (now.size == group.size * 2) {
                var count = 0
                var nowP = Point(r,c)
                
                now.forEach {
                    count += bfs(it.point,nowP)
                    nowP = it.point
                    board[it.point.x][it.point.y] = 0
                }

                group.forEach {
                    it.second.forEach { card ->
                        board[card.point.x][card.point.y] = card.num
                    }
                }
                answer = minOf(count, answer)
            }

            for (g in group) {
                if (!visited[g.first]) {
                    visited[g.first] = true
                    makeCombi(group, now + g.second[0] + g.second[1], visited)
                    makeCombi(group, now + g.second[1] + g.second[0], visited)
                    visited[g.first] = false
                }
            }
        }

        val group = arrays.groupBy { it.num }.toList()
        makeCombi(group)

        return answer
    }
}