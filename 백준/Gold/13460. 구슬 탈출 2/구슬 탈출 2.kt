import java.util.LinkedList
import java.util.Queue

data class Position(var row: Int, var col: Int)
data class State(
    val red: Position,
    val blue: Position,
    var moves: Int,
)


fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().toCharArray() }
    val visited = Array(n) { Array(m) { Array(n) { BooleanArray(m) } } }

    val start = findStartPositions(board)
    val queue: Queue<State> = LinkedList<State>().apply { add(start) }

    println(bfs(board, visited, queue))
}

fun findStartPositions(board: Array<CharArray>): State {
    var red = Position(0, 0)
    var blue = Position(0, 0)
    for (i in board.indices) {
        for (j in board[i].indices) {
            when (board[i][j]) {
                'R' -> red = Position(i, j)
                'B' -> blue = Position(i, j)
            }
        }
    }
    return State(red, blue, 0)
}

fun bfs(board: Array<CharArray>, visited: Array<Array<Array<BooleanArray>>>, queue: Queue<State>): Int {
    val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))


    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current.moves > 10) return -1
        if (board[current.red.row][current.red.col] == 'O') {
            return current.moves
        }

        for (dir in directions) {
            val moved = moveBalls(current, dir, board)
            if (board[moved.blue.row][moved.blue.col] == 'O') continue
            if (!visited[moved.red.row][moved.red.col][moved.blue.row][moved.blue.col]) {
                visited[moved.red.row][moved.red.col][moved.blue.row][moved.blue.col] = true
                moved.moves++
                queue.add(moved)
            }
        }
    }
    return -1
}

fun moveBalls(state: State, direction: IntArray, board: Array<CharArray>): State {
    val movedRed = move(state.red, direction, board)
    val movedBlue = move(state.blue, direction, board)

    if (movedRed == movedBlue && board[movedRed.row][movedRed.col] != 'O') {
        adjustOverlap(state, movedRed, movedBlue, direction)
    }

    return State(movedRed, movedBlue, state.moves)
}


fun move(position: Position, direction: IntArray, board: Array<CharArray>): Position {
    var (row, col) = position
    while (board[row + direction[0]][col + direction[1]] != '#') {
        row += direction[0]
        col += direction[1]
        if (board[row][col] == 'O') break
    }
    return Position(row, col)
}

fun adjustOverlap(state: State, red: Position, blue: Position, direction: IntArray) {
    if (direction[0] != 0) { 
        if (state.red.row < state.blue.row) {
            if (direction[0] == -1) blue.row = red.row + 1 
            else red.row = blue.row - 1
        } else {
            if (direction[0] == -1) red.row = blue.row + 1 
            else blue.row = red.row - 1 
        }
    }
    if (direction[1] != 0) { 
        if (state.red.col < state.blue.col) {
            if (direction[1] == -1) blue.col = red.col + 1
            else red.col = blue.col - 1 
        } else {
            if (direction[1] == -1) red.col = blue.col + 1 
            else blue.col = red.col - 1 
        }
    }
}

