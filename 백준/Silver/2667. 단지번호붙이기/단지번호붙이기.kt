fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arrs = Array(n) { br.readLine().map { it.digitToInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(n) }
    val total = ArrayList<Int>()

    for (x in arrs.indices) {
        for (y in arrs[x].indices) {
            if (arrs[x][y] == 1 && !visited[x][y]) {
                val count: Int = dfs(x, y, arrs, visited)
                total.add(count)
            }
        }
    }

    println(total.size)
    total.sorted().forEach {
        println(it)
    }
}

val moveX = arrayOf(1, -1, 0, 0)
val moveY = arrayOf(0, 0, 1, -1)


fun dfs(x: Int, y: Int, arrs: Array<IntArray>, visited: Array<BooleanArray>): Int {
    var ans = 1
    visited[x][y] = true

    for (i in 0 until 4) {
        val nx = x + moveX[i]
        val ny = y + moveY[i]

        if (nx in visited.indices && ny in visited[0].indices && !visited[nx][ny] && arrs[nx][ny] == 1) {
            ans += dfs(nx,ny,arrs, visited)
        }
    }

    return ans
}