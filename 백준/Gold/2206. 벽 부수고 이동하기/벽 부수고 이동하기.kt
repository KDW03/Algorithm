import java.util.*

data class Node(val x: Int, val y: Int, val wall: Int, val count: Int)

fun bfs(arr: Array<IntArray>, N: Int, M: Int): Int {
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    val queue: Queue<Node> = LinkedList()
    val visited = Array(N) { Array(M) { BooleanArray(2) } }

    queue.add(Node(0, 0, 1, 1))
    visited[0][0][1] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        if (current.x == N - 1 && current.y == M - 1) {
            return current.count
        }

        for (i in 0 until 4) {
            val nx = current.x + dx[i]
            val ny = current.y + dy[i]

            if (nx in 0 until N && ny in 0 until M) {
                if (arr[nx][ny] == 1 && current.wall == 1 && !visited[nx][ny][0]) {
                    visited[nx][ny][0] = true
                    queue.add(Node(nx, ny, 0, current.count + 1))
                }
                if (arr[nx][ny] == 0 && !visited[nx][ny][current.wall]) {
                    visited[nx][ny][current.wall] = true
                    queue.add(Node(nx, ny, current.wall, current.count + 1))
                }
            }
        }
    }

    return -1
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(N) { br.readLine().map { it.digitToInt() }.toIntArray() }

    println(bfs(arr, N, M))
}
