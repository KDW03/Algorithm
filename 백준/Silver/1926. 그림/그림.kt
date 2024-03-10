import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()


    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    var count = 0
    var max = 0

    val dohaji = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)
    fun dfs(dohaji: Array<IntArray>, x: Int, y: Int) : Int {
        var drawCount = 1
        dohaji[x][y] = 0

        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]
            if (nx in dohaji.indices && ny in dohaji[0].indices && dohaji[nx][ny] == 1) {
                drawCount += dfs(dohaji,nx,ny)
            }
        }

        return drawCount
    }

    for (x in 0 until n) {
        for (y in 0 until m) {
            if (dohaji[x][y] == 1) {
                count++
                max = maxOf(max, dfs(dohaji, x, y))
            }
        }
    }

    println(count)
    println(max)
}