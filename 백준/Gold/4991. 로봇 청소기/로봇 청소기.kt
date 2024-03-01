import java.util.LinkedList
import java.util.Queue
import kotlin.math.cos

data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    outer@ while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) break

        val points = ArrayList<Point>()
        var start = Point(0, 0)
        val arr = Array(h) { x ->
            br.readLine().mapIndexed { y, c ->
                if (c == 'o') start = Point(x, y)
                if (c == '*') points.add(Point(x, y))
                c
            }.toTypedArray()
        }

        points.add(0, start)


        val moveX = arrayOf(-1, 1, 0, 0)
        val moveY = arrayOf(0, 0, -1, 1)

        fun bfs(start: Point, dest: Point): Int? {
            val visited = Array(h) { BooleanArray(w) }
            val q: Queue<Pair<Point, Int>> = LinkedList()
            q.add(Pair(start, 0))
            arr[start.x][start.y] = '.'
            visited[start.x][start.y] = true
            while (q.isNotEmpty()) {
                val (p, cost) = q.poll()
                if (p == dest) {
                    return cost
                }

                for (i in 0 until 4) {
                    val nx = p.x + moveX[i]
                    val ny = p.y + moveY[i]
                    if (nx in arr.indices && ny in arr[0].indices && arr[nx][ny] != 'x' && !visited[nx][ny]) {
                        visited[nx][ny] = true
                        q.add(Pair(Point(nx, ny), cost + 1))
                    }
                }
            }
            return null
        }

        val distance = Array(points.size) { IntArray(points.size) { -1 } }
        for (i in 0 until points.size - 1) {
            for (j in 1 until points.size) {
                val s = points[i]
                val d = points[j]
                val cost = bfs(s, d)
                if (cost != null) {
                    distance[i][j] = cost
                    distance[j][i] = cost
                }
            }
        }


        fun permute(points: ArrayList<Point>): Int {
            val size = points.size
            val visited = BooleanArray(size)
            var min = Int.MAX_VALUE
            visited[0] = true

            fun d(now: Array<Int> = arrayOf()) {

                if (now.size == size - 1) {
                    var costs = 0
                    var s = 0

                    for (p in now) {
                        val cost = distance[s][p]
                        if (cost == -1) return
                        costs += cost
                        if (costs >= min) return
                        s = p
                    }
                    min = costs
                }

                for (i in points.indices) {
                    if (!visited[i]) {
                        visited[i] = true
                        d(now + i)
                        visited[i] = false
                    }
                }
            }

            d()

            return if (min == Int.MAX_VALUE) {
                -1
            } else {
                min
            }
        }


        sb.append(permute(points)).append("\n")
    }
    print(sb.toString().trimEnd())
}
