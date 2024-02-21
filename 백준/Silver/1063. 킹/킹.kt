data class Position(var x: Int, var y: Char) {
    fun move(cmd: Char): Boolean {
        return when (cmd) {
            'R' -> {
                val canMove = canMove(x, y + 1)
                if (canMove) y++
                canMove
            }
            'L' -> {
                val canMove = canMove(x, y - 1)
                if (canMove) y--
                canMove
            }
            'B' -> {
                val canMove = canMove(x - 1, y)
                if (canMove) x--
                canMove
            }
            'T' -> {
                val canMove = canMove(x + 1, y)
                if (canMove) x++
                canMove
            }
            else -> false
        }
    }

    private fun canMove(nx: Int, ny: Char) = nx in 1..8 && ny in 'A'..'H'
    override fun toString(): String = "${y}${x}"
}


fun main() {
    val br = System.`in`.bufferedReader()
    val (king, doll, n) = br.readLine().split(" ")

    var kingPosition = Position(king[1].digitToInt(), king[0])
    var dollPosition = Position(doll[1].digitToInt(), doll[0])

    outer@for(i in 0 until n.toInt()) {
        val str = br.readLine()
        val firstKing = kingPosition.copy()
        val firstDoll = dollPosition.copy()

        for (c in str) {
            if (!kingPosition.move(c)) {
                kingPosition = firstKing
                dollPosition = firstDoll
                continue@outer
            }
        }

        if (kingPosition == dollPosition) for (c in str) {
            if (!dollPosition.move(c)) {
                kingPosition = firstKing
                dollPosition = firstDoll
                continue@outer
            }
        }
    }

    println(kingPosition.toString())
    println(dollPosition.toString())
}