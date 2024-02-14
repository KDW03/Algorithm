import java.util.PriorityQueue

data class Position(val x: Int, val y: Int)
enum class DIR {
    L, U, R, D, NONE
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (w, h) = br.readLine().split(" ").map { it.toInt() }
    // c의 위치를 담은 리스트
    val cPoint = ArrayList<Position>()
    val arr = Array(h) { x ->
        br.readLine().mapIndexed { y, value ->
            if (value == 'C') cPoint.add(Position(x, y))
            value
        }
    }

    val a = cPoint[0]
    val b = cPoint[1]

    val q: PriorityQueue<Triple<Position, DIR, Int>> = PriorityQueue { o1, o2 -> o1.third - o2.third }
    val costArr = Array(h) { IntArray(w) { Int.MAX_VALUE } }
    val visited = Array(h) { Array(w) { IntArray(5) { Int.MAX_VALUE } } }
    q.add(Triple(a, DIR.NONE, 0))
    costArr[a.x][a.y] = 0

    val moveX = arrayOf(0, -1, 0, 1)
    val moveY = arrayOf(-1, 0, 1, 0)

    while (q.isNotEmpty()) {
        val (pos, preDir, preCost) = q.poll()
        val (x, y) = pos
        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]
            val nowDir = DIR.values()[i]

            if (nx in arr.indices && ny in arr[0].indices && arr[nx][ny] != '*') {

                if (preDir == DIR.NONE) {
                    if (visited[nx][ny][nowDir.ordinal] <= preCost) continue
                    q.add(Triple(Position(nx, ny), nowDir, preCost))
                    visited[nx][ny][nowDir.ordinal] = preCost
                    costArr[nx][ny] = preCost
                } else {

                    if (preDir == DIR.values()[(i + 2) % 4]) continue

                    if (preDir == nowDir && costArr[nx][ny] >= preCost) {
                        if (visited[nx][ny][nowDir.ordinal] <= preCost) continue
                        q.add(Triple(Position(nx, ny), nowDir, preCost))
                        visited[nx][ny][nowDir.ordinal] = preCost
                        costArr[nx][ny] = preCost
                    }

                    if (preDir != nowDir && costArr[nx][ny] >= preCost + 1) {
                        if (visited[nx][ny][nowDir.ordinal] <= preCost + 1) continue
                        q.add(Triple(Position(nx, ny), nowDir, preCost + 1))
                        visited[nx][ny][nowDir.ordinal] = preCost + 1
                        costArr[nx][ny] = preCost + 1
                    }

                }
            }
        }
    }
    println(costArr[b.x][b.y])
}