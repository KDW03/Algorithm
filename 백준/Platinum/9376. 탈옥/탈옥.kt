import java.util.*

data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val (h, w) = br.readLine().split(" ").map { it.toInt() }

        // 감옥 평면도 확장
        val grid = Array(h + 2) { Array(w + 2) { '.' } }
        val prisoners = mutableListOf<Point>() // 죄수의 위치

        for (i in 1..h) {
            val line = br.readLine()
            for (j in 1..w) {
                // 확장된 곳 가운데에 평면도 업데이트
                grid[i][j] = line[j - 1]
                if (line[j - 1] == '$') prisoners.add(Point(i, j))
            }
        }

        // 각 시작점(죄수 2명, 감옥 밖)으로부터의 최소 문 개수를 저장할 배열
        val distances = Array(3) { Array(h + 2) { IntArray(w + 2) { Int.MAX_VALUE } } }

        // 3가지 경우에 대해 bfs 진행 독립적인 비용 배열 구함
        bfs(grid, prisoners[0], distances[0])
        bfs(grid, prisoners[1], distances[1])
        bfs(grid, Point(0, 0), distances[2])

        // 최소 문 개수를 계산
        var minDoors = Int.MAX_VALUE

        // 각 지점에 대해서 3가지 경우에 대한 비용 합 구함
        for (i in 0 until h + 2) {
            for (j in 0 until w + 2) {
                if (grid[i][j] == '*') continue
                // 최소 지점이 문이라면 중복 계산 -2
                val doors = distances.sumOf { it[i][j] } - if (grid[i][j] == '#') 2 else 0
                minDoors = minOf(minDoors, doors)
            }
        }

        sb.append(minDoors).append("\n")
    }
    print(sb.toString())
}

fun bfs(grid : Array<Array<Char>>, start : Point, distance : Array<IntArray>) {
    val moveX = arrayOf(1,-1,0,0)
    val moveY = arrayOf(0,0,1,-1)

    val queue : Queue<Point> = LinkedList()
    distance[start.x][start.y] = 0 // 시작점의 거리를 0으로 설정
    queue.add(start) // 시작점을 큐에 추가

    while (queue.isNotEmpty()) {
        val (x,y) = queue.remove()
        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]

            // 범위 내고 벽이 아니라면 진행
            if (nx !in grid.indices || ny !in grid[0].indices || grid[nx][ny] == '*') continue

            // 벽이라면 비용 증가
            val newDistance = distance[x][y] + if (grid[nx][ny] == '#') 1 else 0

            // 비용이 갱신된다면 q에 넣어주기
            if (newDistance < distance[nx][ny]) {
                distance[nx][ny] = newDistance
                queue.add(Point(nx, ny))
            }
        }
    }

}