import java.util.*

var max = 0
fun main() {
    val br = System.`in`.bufferedReader()
    // 육지(L)나 바다(W)로 표시
    // 한 칸 이동하는데 한 시간
    // 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳


    // n,m (세로,가로)입력
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // board(n,m) 크기 입력
    val board = Array(n) { br.readLine().toCharArray() }
    // 각 육지에서 bfs했을 때

    for (x in 0 until n) {
        for (y in 0 until m) {
            // 육지이면 bfs 시작
            if (board[x][y] == 'L') {
                val visited = Array(n) { BooleanArray(m) }
                bfs(board, x, y, visited)
            }
        }
    }

    println(max)
    // 가장 먼 최대거리 저장
}

val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(1, -1, 0, 0)
fun bfs(board: Array<CharArray>, x: Int, y: Int, visited: Array<BooleanArray>) {
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    visited[x][y] = true
    q.add(Triple(x, y, 0))
    while (q.isNotEmpty()) {
        // 현재 육지에서 이동
        val p = q.poll()
        for (i in 0 until 4) {
            val nx = p.first + moveX[i]
            val ny = p.second + moveY[i]
            // 범위내에 있고 아직 방문하지 않았다면
            if (nx in board.indices && ny in board[0].indices && !visited[nx][ny] && board[nx][ny] == 'L') {
                // 방문처리하고
                visited[nx][ny] = true
                // 이전 거리에서 한 단계 추가
                q.add(Triple(nx, ny, p.third + 1))
                max = maxOf(p.third + 1, max)
            }
        }
    }
}