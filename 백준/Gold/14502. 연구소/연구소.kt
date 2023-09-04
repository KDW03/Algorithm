data class Location(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val virusArr = mutableListOf<Location>()
    val nothingArr = mutableListOf<Location>()
    var wallcount = 3
    val arr = Array(n) { x ->
        br.readLine().split(" ").map { it.toInt() }.apply {
            this.forEachIndexed { y, v ->
                when (v) {
                    0 -> nothingArr.add(Location(x, y))
                    1 -> wallcount++
                    2 -> virusArr.add(Location(x, y))
                }
            }
        }.toIntArray()
    }
    // 바이러스가 있는 위치를 저장
    // 벽 및 바이러스가 없는 곳 위치 저장
    var max = 0

    for (i in 0 until nothingArr.size - 2) {
        for (j in i + 1 until nothingArr.size - 1) {
            for (k in j + 1 until nothingArr.size) {
                // 벽 및 바이러스가 없는 곳에서 3개를 선택해서 벽을 친 후
                val pick = arrayOf(nothingArr[i], nothingArr[j], nothingArr[k])
                pick.forEach {
                    arr[it.x][it.y] = 1
                }
                // 바이러스 위치하나당 dfs 시작

                var count = 0
                val visited = Array(n) { BooleanArray(m) }
                virusArr.forEach {
                    count += dfs(arr, it, visited, n, m)
                }
                val now = n * m - (count + wallcount)
                max = maxOf(now, max)

                // 다시 벽 철거
                pick.forEach {
                    arr[it.x][it.y] = 0
                }
            }
        }
    }

    println(max)
}

val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(1, -1, 0, 0)
fun dfs(arr: Array<IntArray>, start: Location, visited: Array<BooleanArray>, n: Int, m: Int): Int {
    // virus 개수
    visited[start.x][start.y] = true
    var count = 1
    for (i in 0 until 4) {
        val nx = start.x + moveX[i]
        val ny = start.y + moveY[i]
        // 아무것도없고 바이러스가 전파되지않았다면
        if (nx in 0 until n && ny in 0 until m && arr[nx][ny] == 0 && !visited[nx][ny]) {
            count += dfs(arr, Location(nx, ny), visited, n, m)
        }
    }
    return count
}
