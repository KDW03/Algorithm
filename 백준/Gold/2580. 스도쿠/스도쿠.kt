data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val candidate = ArrayList<Point>()
    val board = Array(9) { x ->
        br.readLine().split(" ").mapIndexed { y, v ->
            if (v == "0") candidate.add(Point(x, y))
            v.toInt()
        }.toIntArray()
    }
    findAnswer(board, candidate)

    for (x in 0 until board.size) {
        println(board[x].joinToString(" "))
    }
}

fun findAnswer(board: Array<IntArray>, candidate: ArrayList<Point>, i: Int = 0): Boolean {
    if (i == candidate.size) return true

    val (x, y) = candidate[i]
    val set = HashSet<Int>()

    for (j in 0 until 9) set.add(board[x][j])
    for (j in 0 until 9) set.add(board[j][y])

    val sx = (x / 3) * 3
    val sy = (y / 3) * 3

    for (nx in sx until sx + 3) {
        for (ny in sy until sy + 3) {
            set.add(board[nx][ny])
        }
    }

    for (num in 1 until 10) {
        if (!set.contains(num)) {
            board[x][y] = num
            val result = findAnswer(board, candidate, i + 1)
            if (result) return true
            board[x][y] = 0
        }
    }
    return false
}