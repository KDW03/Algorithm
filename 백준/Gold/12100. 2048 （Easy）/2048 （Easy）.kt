var max = Int.MIN_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    dfs(board, 0)
    println(max)
}

enum class Direction {
    LEFT, RIGHT, UP, DOWN
}

fun dfs(board: Array<IntArray>, depth: Int) {
    if (depth == 5) {
        max = maxOf(max, board.maxOf { it.maxOrNull() ?: 0 })
        return
    }

    for (dir in Direction.values()) {
        val newBoard = moveAndMergeBoard(board, dir)
        dfs(newBoard, depth + 1)
    }
}

fun moveAndMergeBoard(board: Array<IntArray>, direction: Direction): Array<IntArray> {
    val n = board.size
    val newBoard = Array(n) { IntArray(n) }
    val merged = Array(n) { BooleanArray(n) }

    when (direction) {
        Direction.LEFT -> {
            for (i in 0 until n) {
                var index = 0
                for (j in 0 until n) {
                    if (board[i][j] == 0) continue
                    if (index > 0 && newBoard[i][index - 1] == board[i][j] && !merged[i][index - 1]) {
                        newBoard[i][index - 1] *= 2
                        merged[i][index - 1] = true
                    } else {
                        newBoard[i][index] = board[i][j]
                        if (board[i][j] == newBoard[i][index]) {
                            merged[i][index] = false
                        }
                        index++
                    }
                }
            }
        }
        Direction.RIGHT -> {
            for (i in 0 until n) {
                var index = n - 1
                for (j in n - 1 downTo 0) {
                    if (board[i][j] == 0) continue
                    if (index < n - 1 && newBoard[i][index + 1] == board[i][j] && !merged[i][index + 1]) {
                        newBoard[i][index + 1] *= 2
                        merged[i][index + 1] = true
                    } else {
                        newBoard[i][index] = board[i][j]
                        if (board[i][j] == newBoard[i][index]) {
                            merged[i][index] = false
                        }
                        index--
                    }
                }
            }
        }
        Direction.UP -> {
            for (j in 0 until n) {
                var index = 0
                for (i in 0 until n) {
                    if (board[i][j] == 0) continue
                    if (index > 0 && newBoard[index - 1][j] == board[i][j] && !merged[index - 1][j]) {
                        newBoard[index - 1][j] *= 2
                        merged[index - 1][j] = true
                    } else {
                        newBoard[index][j] = board[i][j]
                        if (board[i][j] == newBoard[index][j]) {
                            merged[index][j] = false
                        }
                        index++
                    }
                }
            }
        }
        Direction.DOWN -> {
            for (j in 0 until n) {
                var index = n - 1
                for (i in n - 1 downTo 0) {
                    if (board[i][j] == 0) continue
                    if (index < n - 1 && newBoard[index + 1][j] == board[i][j] && !merged[index + 1][j]) {
                        newBoard[index + 1][j] *= 2
                        merged[index + 1][j] = true
                    } else {
                        newBoard[index][j] = board[i][j]
                        if (board[i][j] == newBoard[index][j]) {
                            merged[index][j] = false
                        }
                        index--
                    }
                }
            }
        }
    }

    return newBoard
}
