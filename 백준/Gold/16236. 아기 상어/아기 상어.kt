import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    var babyLocation = Pair(0, 0)
    val arr = Array(n) { x ->
        br.readLine().split(" ").mapIndexed { y, it ->
            if (it == "9") {
                babyLocation = Pair(x, y)
                0  // 아기 상어의 위치를 0으로 설정
            } else {
                it.toInt()
            }
        }.toIntArray()
    }

    var count = 0
    var babySize = 2
    var levelup = 0

    while (true) {
        val visited = Array(n) { BooleanArray(n) }
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        val fishList = mutableListOf<Triple<Int, Int, Int>>()

        q.add(Triple(babyLocation.first, babyLocation.second, 0))

        while (q.isNotEmpty()) {
            val (x, y, time) = q.poll()

            if (visited[x][y]) continue
            visited[x][y] = true

            if (arr[x][y] in 1 until babySize) {
                fishList.add(Triple(x, y, time))
                continue
            }

            val dx = arrayOf(-1, 0, 1, 0)
            val dy = arrayOf(0, 1, 0, -1)

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0 until n && ny in 0 until n && arr[nx][ny] <= babySize && !visited[nx][ny]) {
                    q.add(Triple(nx, ny, time + 1))
                }
            }
        }

        if (fishList.isEmpty()) break  // 더 이상 먹을 물고기가 없으면 종료

        fishList.sortWith(compareBy({ it.third }, { it.first }, { it.second }))  // 거리, x, y 순으로 정렬
        val (fx, fy, ftime) = fishList[0]

        arr[fx][fy] = 0  // 물고기 먹기
        babyLocation = Pair(fx, fy)  // 아기 상어의 새 위치
        count += ftime  // 시간 누적

        levelup++
        if (levelup == babySize) {
            babySize++
            levelup = 0
        }
    }

    println(count)
}
