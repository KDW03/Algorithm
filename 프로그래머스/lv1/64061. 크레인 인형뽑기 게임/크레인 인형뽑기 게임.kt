import java.util.*;

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack: Stack<Int> = Stack()
        val lastIndex = board.size
        moves.forEach { rcol ->
            val col = rcol - 1
            for (i in 0 until lastIndex) {
                if (board[i][col] != 0) {
                    val pick = board[i][col]
                    if (stack.isNotEmpty() && pick == stack.peek()) {
                        stack.pop()
                        answer += 2
                    } else {
                        stack.push(pick)
                    }
                    board[i][col] = 0
                    break
                }
            }
        }
        return answer
    }
}