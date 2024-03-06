import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    // n x n 크기 땅
    // l명이상 r명이하
    val (n, l, r) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val moveX = arrayOf(1, -1, 0, 0)
    val moveY = arrayOf(0, 0, 1, -1)

    fun dfs(arr: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int, range: IntRange): Pair<Int, Int> {
        visited[x][y] = true
        val now = arr[x][y]
        var partSum = now
        var partCount = 1

        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]
            if (nx in arr.indices && ny in arr[0].indices && !visited[nx][ny] && abs(now - arr[nx][ny]) in range) {
                val result = dfs(arr, visited, nx, ny, range)
                partCount += result.first
                partSum += result.second
            }
        }

        arr[x][y] = -1
        return Pair(partCount, partSum)
    }
    // dfs가 더이상안될때 까지 반복
    var answer = 0
    while (true) {
        val visited = Array(n) { BooleanArray(n) }
        var flag = false
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (!visited[x][y]) {
                    val (count, sum) = dfs(arr, visited, x, y, l..r)
                    val per = sum / count
                    // 연합 개수가 1보다 크다면
                    if (count > 1) {
                        flag = true
                        for (tx in 0 until n) {
                            for (ty in 0 until n) {
                                if (arr[tx][ty] == -1) arr[tx][ty] = per
                            }
                        }
                    } else {
                        arr[x][y] = per
                    }
                }
            }
        }
        if (!flag) break
        answer++
    }

    println(answer)
}
