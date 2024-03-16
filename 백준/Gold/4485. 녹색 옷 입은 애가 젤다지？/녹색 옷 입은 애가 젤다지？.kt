import java.util.PriorityQueue

data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)


    var index = 0
    outer@while (true) {
        val n = br.readLine().toInt()
        if (n == 0) break
        index++

        val arr = Array(n) {
            br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        val visited = Array(n) {
            BooleanArray(n)
        }

        val start = Point(0, 0)
        val end = Point(n - 1, n - 1)
        val range = 0 until n

        val q = PriorityQueue<Pair<Point, Int>> { o1, o2 ->
            o1.second - o2.second
        }

        q.add(Pair(start, arr.first().first()))
        while (q.isNotEmpty()) {
            val (p, c) = q.poll()

            if (p == end) {
                sb.append("Problem ${index}: $c").append("\n")
                continue@outer
            }

            val (x, y) = p

            if (visited[x][y]) continue
            visited[x][y] = true

            for (i in 0 until 4) {
                val nx = x + moveX[i]
                val ny = y + moveY[i]
                // 범위내에있고 방문하지 않았다면
                if (nx in range && ny in range && !visited[nx][ny]) q.add(Pair(Point(nx, ny), c + arr[nx][ny]))
            }
        }
    }

    println(sb.toString().trimEnd())
}