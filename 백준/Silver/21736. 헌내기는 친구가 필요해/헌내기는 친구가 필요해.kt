fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var now = Pair(0, 0)

    val arr = Array(n) { x ->
        br.readLine().mapIndexed() { y, c ->
            if (c == 'I') {
                now = Pair(x, y)
            }
            c
        }
    }

    val visited = Array(n) { BooleanArray(m) }
    val moveX = arrayOf(0, 0, 1, -1)
    val moveY = arrayOf(1, -1, 0, 0)

    fun dfs(x: Int, y: Int): Int {

        visited[x][y] = true
        var ans = if (arr[x][y] == 'P') 1 else 0

        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]

            if (nx in arr.indices && ny in arr[0].indices && !visited[nx][ny] && arr[nx][ny] != 'X') {
                ans += dfs(nx, ny)
            }
        }

        return ans
    }

    val answer = dfs(now.first, now.second)
    println(if (answer == 0) "TT" else answer)
}