data class Position(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val board = Array(n) {
        br.readLine().toCharArray()
    }

    var headPosition = Position(0, 0)
    outer@ for (i in 0 until n) {
        for (j in 0 until n) {
            if (board[i][j] == '*') {
                headPosition = Position(i, j)
                break@outer
            }
        }
    }

    var heartPosition = Position(headPosition.x + 1, headPosition.y)

    var leftArm = 0
    var rightArm = 0


    for (y in heartPosition.y - 1 downTo 0) {
        if (y in 0 until n && board[heartPosition.x][y] == '*') {
            leftArm++
            continue
        }
        break
    }

    for (y in heartPosition.y + 1 until n) {
        if (y in 0 until n && board[heartPosition.x][y] == '*') {
            rightArm++
            continue
        }
        break
    }

    var waist = 0
    var waistEndPosition = Position(0, 0)
    for (x in heartPosition.x + 1 until n) {
        if (x in 0 until n && board[x][heartPosition.y] == '*') {
            waist++
            waistEndPosition = Position(x, headPosition.y)
            continue
        }
        break
    }

    var leftLeg = 0
    var rightLeg = 0
    for (x in waistEndPosition.x + 1 until n) {
        if (x in 0 until n) {
            if (waistEndPosition.y - 1 in 0 until n && board[x][heartPosition.y - 1] == '*') leftLeg++
            if (waistEndPosition.y + 1 in 0 until n && board[x][heartPosition.y + 1] == '*') rightLeg++
        }
    }

    println("${heartPosition.x + 1} ${heartPosition.y + 1}")
    println("$leftArm $rightArm $waist $leftLeg $rightLeg")
}