import java.io.BufferedReader
import java.io.InputStreamReader

val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun dfs(x: Int, y: Int, field: Array<Array<Int>>) {
    field[x][y] = 0 // 방문 표시

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx in 0 until field.size && ny in 0 until field[0].size && field[nx][ny] == 1) {
            dfs(nx, ny, field)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val field = Array(m) { Array(n) { 0 } }

        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            field[x][y] = 1
        }

        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (field[i][j] == 1) {
                    dfs(i, j, field)
                    count++
                }
            }
        }

        println(count)
    }
}
