fun main() {
    val br = System.`in`.bufferedReader()

    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(r) { br.readLine().toCharArray() }
    val start = Pair(r - 1, 0)
    val end = Pair(0, c - 1)
    // 각 경우 수 마다 전부 다르게

    val visited = Array(r) { BooleanArray(c) { false } }
    println(dfs(arr, start, end, k, visited, 1))
}

val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(1, -1, 0, 0)

fun dfs(
    arr: Array<CharArray>,
    start: Pair<Int, Int>,
    end: Pair<Int, Int>,
    k: Int,
    visited: Array<BooleanArray>,
    now: Int = 1
): Int {


    var count = 0
    if (now > k) return 0

    if (start == end && k == now) return 1

    visited[start.first][start.second] = true

    for (i in 0 until 4) {
        val nx = start.first + moveX[i]
        val ny = start.second + moveY[i]
        // 아직 방문하지 않았고 갈 수 있다면
        if (nx in arr.indices && ny in arr[0].indices && !visited[nx][ny] && arr[nx][ny] != 'T') {
            count += dfs(arr, Pair(nx, ny), end, k, visited, now + 1)
            // 다른 경로로 가는 경우도 보장하기 살펴보기 위해
            visited[nx][ny] = false
        }
    }

    return count
}