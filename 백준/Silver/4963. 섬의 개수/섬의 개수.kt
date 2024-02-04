val moveX = arrayOf(1, -1, 0, 0, 1, -1, 1, -1)
val moveY = arrayOf(0, 0, -1, 1, 1, -1, -1, 1)

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) break

        val arr = Array(h) {
            br.readLine().split(" ").map {
                it.toInt()
            }.toIntArray()
        }

        val visited = Array(h) { BooleanArray(w) }
        var count = 0

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, arr, visited)
                    count++
                }
            }
        }

        sb.append(count).append("\n")
    }

    println(sb.toString())
}

fun dfs(x: Int, y: Int, arr: Array<IntArray>, visited: Array<BooleanArray>) {
    visited[x][y] = true

    for (i in moveX.indices) {
        val nx = x + moveX[i]
        val ny = y + moveY[i]

        if (nx in arr.indices && ny in arr[0].indices && !visited[nx][ny] && arr[nx][ny] == 1) {
            dfs(nx, ny, arr, visited)
        }
    }
}