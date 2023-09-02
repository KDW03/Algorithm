fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var maxHeight = 0
    val arr = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.toIntArray().apply {
            maxHeight = maxOf(maxHeight, maxOf { it })
        }
    }
    var max = 1
    var height = 1
    while (height < maxHeight) {
        var count = 0
        val newArr = arr.map { it.map { it <= height }.toMutableList() }
        for (x in newArr.indices) {
            for (y in newArr[0].indices) {
                // 잠기지 않았다면
                if (!newArr[x][y]) {
                    count++
                    dfs(newArr, x, y, n)
                }
            }
        }
        max = maxOf(max, count)
        height++
    }
    println(max)
}

val moveX = arrayOf(-1, 1, 0, 0)
val moveY = arrayOf(0, 0, 1, -1)

fun dfs(newArr: List<MutableList<Boolean>>, x: Int, y: Int, n: Int) {
    newArr[x][y] = true
    for (i in 0 until 4) {
        val nx = x + moveX[i]
        val ny = y + moveY[i]
        if (nx in 0 until n && ny in 0 until n && !newArr[nx][ny])
            dfs(newArr, nx, ny, n)
    }
}
