fun main() {
    val br = System.`in`.bufferedReader()
    var (n, m) = br.readLine().split(" ").map { it.toInt() }
    var cheeseCount = 0
    val arr = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray().apply {
            cheeseCount += count { c -> c == 1 }
        }
    }

    var count = 0
    var pre = 0
    while (cheeseCount > 0) {
        val visited = Array(n) { BooleanArray(m) }
        visited[0][0] = true
        pre = dfs(arr, 0, 0, visited)
        cheeseCount -= pre
        count++
    }

    println(count)
    println(pre)
}


val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(-1, 1, 0, 0)

fun dfs(arr: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>): Int {
    var count = 0

    for (i in 0 until 4) {
        val nx = x + moveX[i]
        val ny = y + moveY[i]

        if (nx in arr.indices && ny in arr[0].indices && !visited[nx][ny]) {
            visited[nx][ny] = true

            if (arr[nx][ny] == 0) {
                count += dfs(arr, nx, ny, visited)
            } else {
                count++
                arr[nx][ny] = 0
            }

        }
    }

    return count
}