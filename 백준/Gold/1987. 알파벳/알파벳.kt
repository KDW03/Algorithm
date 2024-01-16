fun main() {
    val br = System.`in`.bufferedReader()
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(R) { br.readLine().map { it - 'A' } }
    var maxMove = 0
    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)
    
    fun dfs(x: Int, y: Int, dist: Int, visited: Int) {
        maxMove = maxOf(maxMove, dist)
        for (i in 0 until 4) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]

            if (nx in 0 until R && ny in 0 until C) {
                val alphabet = arr[nx][ny]
                val mask = 1 shl alphabet

                if (visited and mask == 0) {
                    dfs(nx, ny, dist + 1, visited or mask)
                }
            }
        }
    }

    val visited = 1 shl arr[0][0]
    dfs(0, 0, 1, visited)
    println(maxMove)
}