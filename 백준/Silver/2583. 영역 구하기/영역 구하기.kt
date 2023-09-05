fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    var arr = Array(m) { IntArray(n) }

    repeat(k) {
        val (down, left, top, right) = br.readLine().split(" ").map { it.toInt() }
        for (x in down until top) {
            for (y in left until right) {
                arr[x][y] = 1
            }
        }
    }

    var count = 0
    val l = mutableListOf<Int>()
    arr.forEachIndexed { x, v ->
        v.forEachIndexed { y, iv ->
            if (iv == 0) {
                val d = dfs(x, y, arr)
                l.add(d)
                count++
            }
        }
    }
    println(count)
    println(l.sorted().joinToString(" "))
}

val moveX = arrayOf(1, -1, 0, 0)
val moveY = arrayOf(0, 0, -1, 1)
fun dfs(x: Int, y: Int, arr: Array<IntArray>): Int {
    var d = 1
    arr[x][y] = 1
    for (i in 0 until 4) {
        val nx = x + moveX[i]
        val ny = y + moveY[i]

        if (nx in arr.indices && ny in arr[0].indices && arr[nx][ny] == 0) {
            d += dfs(nx, ny, arr)
        }
    }
    return d
}
