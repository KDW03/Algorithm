import java.util.LinkedList

data class Position(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, x, y, k) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val diceHorizontal: LinkedList<Int> = LinkedList<Int>().apply { addAll(arrayOf(0, 0, 0)) }
    val diceVertical: LinkedList<Int> = LinkedList<Int>().apply { addAll(arrayOf(0, 0, 0, 0)) }

    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)
    var nowPosition = Position(x, y)
    val cmds = br.readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    for (it in cmds) {
        val moveIndex = it - 1
        val nx = nowPosition.x + moveX[moveIndex]
        val ny = nowPosition.y + moveY[moveIndex]
        // 바깥쪽인 경우 무시
        if (!(nx in map.indices && ny in map[0].indices)) continue
        nowPosition = Position(nx,ny)
        val nowPositionMapValue = map[nx][ny]
        moveDice(diceHorizontal, diceVertical, it)
        sb.append(diceVertical[1]).append("\n")
        if (nowPositionMapValue == 0) {
            map[nx][ny] = diceVertical.last()
        } else {
            diceVertical.removeLast()
            diceVertical.addLast(nowPositionMapValue)
            map[nx][ny] = 0
        }
    }
    print(sb.toString())
}

// 1 -> 오
// 2 -> 왼
// 3 -> 위
// 4 -> 아래
fun moveDice(diceHorizontal: LinkedList<Int>, diceVertical: LinkedList<Int>, cmd: Int) {
    when (cmd) {
        1 -> {
            val under = diceVertical.removeLast()
            diceHorizontal.addFirst(under)
            val newUnder = diceHorizontal.removeLast()
            diceVertical.addLast(newUnder)
            syncDeque(diceHorizontal,diceVertical)
        }
        2 -> {
            val under = diceVertical.removeLast()
            diceHorizontal.addLast(under)
            val newUnder = diceHorizontal.removeFirst()
            diceVertical.addLast(newUnder)
            syncDeque(diceHorizontal,diceVertical)
        }
        3 -> {
            val newUnder = diceVertical.removeFirst()
            diceVertical.addLast(newUnder)
            syncDeque(diceVertical,diceHorizontal)
        }
        4 -> {
            val newUnder = diceVertical.removeLast()
            diceVertical.addFirst(newUnder)
            syncDeque(diceVertical,diceHorizontal)
        }
    }
}

// 동기화 함수
// LR 이면 HORIZONTAL에 맞춰서
// UD 이면 VERTICAL에 맞춰서
// a에 맞춰서 b가 변경
fun syncDeque(a: LinkedList<Int>, b: LinkedList<Int>) {
    b[1] = a[1]
}