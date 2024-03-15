import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    while (true) {
        val board = br.readLine()
        if (board == "end") break
        val countMap = board.groupingBy { it }.eachCount()
        val xCount = countMap.getOrDefault('X', 0)
        val oCount = countMap.getOrDefault('O', 0)


        // oCount가 더 크거나 xCount가 oCount보다 2개 이상 많다면 false
        if (oCount > xCount || (xCount - oCount) > 1) {
            sb.append("invalid").append("\n")
            continue
        }

        val conX = ArrayList<ArrayList<Int>>()
        val conO = ArrayList<ArrayList<Int>>()

        // 각 행마다 가로 검사
        outer@ for (start in 0 until 9 step 3) {
            val first = board[start]

            if (first == '.') continue@outer
            val tmp = arrayListOf<Int>()

            for (position in start + 1 until start + 3) {
                if (first != board[position]) continue@outer
                tmp.add(position)
            }

            tmp.add(start)
            if (first == 'X') {
                conX.add(tmp)
            } else {
                conO.add(tmp)
            }
        }

        // 열 검사
        outer@ for (start in 0 until 3) {
            val first = board[start]

            if (first == '.') continue@outer
            val tmp = arrayListOf<Int>()

            for (position in start + 3 until 9 step 3) {
                if (first != board[position]) continue@outer
                tmp.add(position)
            }
            
            tmp.add(start)
            if (first == 'X') {
                conX.add(tmp)
            } else {
                conO.add(tmp)
            }
        }

        // 대각선 검사
        val leftFirst = board[0]
        if (leftFirst != '.') {
            if (leftFirst == board[4] && leftFirst == board[8]) {
                if (leftFirst == 'X') {
                    conX.add(arrayListOf(0, 4, 8))
                } else {
                    conO.add(arrayListOf(0, 4, 8))
                }
            }
        }

        val rightFirst = board[2]
        if (rightFirst != '.') {
            if (rightFirst == board[4] && rightFirst == board[6]) {
                if (rightFirst == 'X') {
                    conX.add(arrayListOf(2, 4, 6))
                } else {
                    conO.add(arrayListOf(2, 4, 6))
                }
            }
        }


        //O가 이기는경우
        if (oCount == xCount && conX.size == 0) {
            if (conO.size == 1) {
                sb.append("valid").append("\n")
                continue
            }
        }

        // X가 이기는 경우
        if (xCount - oCount == 1 && conO.size == 0) {
            if (conX.size == 1) {
                sb.append("valid").append("\n")
                continue
            } else if (conX.size == 2) {
                val set = hashSetOf<Int>()
                conX.forEach {
                    set.addAll(it)
                }
                if (set.size <= 5) {
                    sb.append("valid").append("\n")
                    continue
                }
            }
        }

        // 무승부
        if (conO.size == 0 && conX.size == 0 && oCount + xCount == 9) {
            sb.append("valid").append("\n")
            continue
        }

        // 잘못된 경우
        sb.append("invalid").append("\n")
    }

    print(sb.toString().trimEnd())
}
