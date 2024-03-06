val answer = IntArray(3)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    countBoard(board, n)

    answer.forEach {
        println(it)
    }
}

fun countBoard(board: Array<List<Int>>, n: Int, startX: Int = 0, startY: Int = 0) {
    val first = board[startX][startY]

    if (n == 1) {
        answer[first + 1]++
        return
    }

    var allSame = true
    outer@ for (x in startX until startX + n) {
        for (y in startY until startY + n) {
            if (board[x][y] != first) {
                allSame = false
                break
            }
        }
    }

    if (allSame) {
        answer[first + 1]++
    } else {
        val newN = n / 3
        for (i in 0 until 3) {
            val nx = startX + (newN * i)
            for (j in 0 until 3) {
                val ny = startY + (newN * j)
                countBoard(board, newN, nx, ny)
            }
        }
    }
}