fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = Array(n) { br.readLine().map { it.toString() } }
    val arrTwo = arr.map {
        it.map { s ->
            if (s == "G") "R"
            else s
        }
    }.toTypedArray()

    val visitedOne = Array(n) { BooleanArray(n) }
    val visitedTwo = Array(n) { BooleanArray(n) }
    var countOne = 0
    var countTwo = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visitedOne[i][j]) {
                dfs(i, j, arr, visitedOne,arr[i][j])
                countOne++
            }

            if (!visitedTwo[i][j]) {
                dfs(i, j, arrTwo, visitedTwo, arrTwo[i][j])
                countTwo++
            }
        }
    }

    println("$countOne $countTwo")
}

val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(1, -1, 0, 0)

fun dfs(x: Int, y: Int, arr: Array<List<String>>, visited: Array<BooleanArray>, value: String) {

    visited[x][y] = true

    for (i in 0 until 4) {
        val nx = x + moveX[i]
        val ny = y + moveY[i]
        if (nx in arr.indices && ny in arr[0].indices && !visited[nx][ny] && arr[nx][ny] == value) {
            dfs(nx, ny, arr, visited, value)
        }
    }
}