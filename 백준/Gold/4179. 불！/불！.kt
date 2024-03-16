import java.util.LinkedList
import java.util.Queue

data class Point(val what: Char, val x: Int, val y: Int, val depth: Int = 0)

fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    var start = Point('J', 0, 0)
    val firePoints = arrayListOf<Point>()
    val q: Queue<Point> = LinkedList()


    val arr = Array(r) { x ->
        br.readLine().mapIndexed { y, c ->
            if (c == 'J') start = Point(c, x, y)
            if (c == 'F') firePoints.add(Point(c, x, y))
            c
        }.toCharArray()
    }

    // 불길 먼저 확산
    q.addAll(firePoints)
    q.add(start)

    val moveX = arrayOf(0, 0, 1, -1)
    val moveY = arrayOf(1, -1, 0, 0)

    fun inRange(x: Int, y: Int): Boolean = x in arr.indices && y in arr[0].indices

    while (q.isNotEmpty()) {
        val (w, x, y, depth) = q.poll()
        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]
            if (inRange(nx, ny)) {

                if (arr[nx][ny] != '#') {
                    // 지훈이인데 가려는 곳이 초행길이면서 불길이 없는 곳이라면
                    if (w == 'J' && arr[nx][ny] == '.') {
                        arr[nx][ny] = 'J'
                        q.add(Point(w, nx, ny, depth + 1))
                    }

                    // 가는 곳이 불길이 아니라면
                    if (w == 'F' && arr[nx][ny] != 'F') {
                        // 불길 확산
                        arr[nx][ny] = 'F'
                        q.add(Point(w, nx, ny, depth + 1))
                    }
                }

            } else {

                // 범위 박인데 지훈이라면 탈출
                if (w == 'J') {
                    println(depth + 1)
                    return
                }

            }
        }
    }
    println("IMPOSSIBLE")
}