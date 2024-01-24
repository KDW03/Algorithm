data class Position(val x: Int, val y: Int)

val moveX = arrayOf(-1, 0, 1, 0)
val moveY = arrayOf(0, 1, 0, -1)
// d
// 0 : U
// 1 : R
// 2 : D
// 3 : L

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val (r, c, d) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    var nowPosition = Position(r, c)
    var nowDir = d
    var count = 0
    while (true) {
        if (arr[nowPosition.x][nowPosition.y] == 0) {
            arr[nowPosition.x][nowPosition.y] = -1
            count++
        }
        if (!checkAround(arr, nowPosition)) {
            val newDir = (nowDir + 2) % 4
            val nx = nowPosition.x + moveX[newDir]
            val ny = nowPosition.y + moveY[newDir]
            if (nx in arr.indices && ny in arr[0].indices && arr[nx][ny] <= 0) {
                nowPosition = Position(nx, ny)
            } else {
                break
            }
        } else {
            nowDir--
            if (nowDir < 0) nowDir = 3
            val nx = nowPosition.x + moveX[nowDir]
            val ny = nowPosition.y + moveY[nowDir]

            if (nx in arr.indices && ny in arr[0].indices && arr[nx][ny] == 0) nowPosition = Position(nx,ny)
        }
    }
    println(count)
}

// 주위에 청소할수있는 곳이 있다면 true 아니면 false
fun checkAround(arr: Array<IntArray>, nowPosition: Position): Boolean {

    for (i in 0 until 4) {
        val nx = nowPosition.x + moveX[i]
        val ny = nowPosition.y + moveY[i]
        if (nx in arr.indices && ny in arr[0].indices) if (arr[nx][ny] == 0) return true
    }

    return false
}