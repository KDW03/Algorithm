import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import java.util.concurrent.CountDownLatch

fun main() {
    val inputQueue: Queue<Int> = LinkedList()
    val br = System.`in`.bufferedReader()
    val board = Board()
    var result = 0
    var st: StringTokenizer



    for (i in 0 until 5) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until 5) {
            board.bingoBoard[i][j] = st.nextToken().toInt()
        }
    }


    for (i in 0 until 5) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until 5) {
            inputQueue.add(st.nextToken().toInt())

        }
    }

    while (true) {
        result++
        if (board.check(inputQueue.poll())) break
    }

    println(result)

}

class Board {
    val bingoBoard = Array(5) { Array(5) { 0 } }
    var bingoCount = 0
    private var crossPairFlag1 = true
    private var crossPairFlag2 = true
    private val crossPair1 = arrayListOf(Pair(0, 4), Pair(1, 3), Pair(2, 2), Pair(3, 1), Pair(4, 0))
    private val crossPair2 = arrayListOf(Pair(0, 0), Pair(1, 1), Pair(2, 2), Pair(3, 3), Pair(4, 4))
    private val bingoRow = ArrayList<Int>()
    private val bingoColumn = ArrayList<Int>()


    fun check(x: Int): Boolean {
        for (i in 0 until 5) {
            val tmp = bingoBoard[i].indexOf(x)
            if (tmp == -1) continue
            else {
                bingoBoard[i][tmp] = 0
                return checkBingo(i, tmp) >= 3
            }
        }
        return false
    }

    private fun checkBingo(row: Int, column: Int): Int {


        if (!bingoRow.contains(row)) {
            for (i in 0 until 5) {
                // 만약 하나라도 체크가 안됬다면 나가고
                if (bingoBoard[row][i] != 0) break
                if (i == 4) bingoRow.add(row)
            }
        }

        if (!bingoColumn.contains(column)) {
            for (i in 0 until 5) {
                if (bingoBoard[i][column] != 0) break
                if (i == 4) bingoColumn.add(column)
            }
        }

        //대각선 확인 필요하다면
        if (crossPairFlag1 && crossPair1.contains(Pair(row, column))) {
            for ((idx, value) in crossPair1.withIndex()) {
                if (bingoBoard[value.first][value.second] != 0) {
                    break
                }
                if (idx == 4) {
                    crossPairFlag1 = false
                    bingoCount++
                }
            }
        }

        if (crossPairFlag2 && crossPair2.contains(Pair(row, column))) {
            for ((idx, value) in crossPair2.withIndex()) {
                if (bingoBoard[value.first][value.second] != 0) { //0이 아니라면 즉 체크되지 않았다면
                    break
                }
                if (idx == 4) {
                    crossPairFlag2 = false
                    bingoCount++
                }
            }
        }

        return bingoCount + bingoRow.size + bingoColumn.size

    }
}



