import java.util.LinkedList
import java.util.Queue

data class Wheel(val num: Int, var moved: Boolean = false) {
    var nsState: LinkedList<Int> = LinkedList()
}

fun moveWheel(wheel: Wheel, dir: Int) {

    val wheelNsState = wheel.nsState
    if (dir == 1) {
        val last = wheelNsState.removeLast()
        wheelNsState.addFirst(last)
    }
    if (dir == -1) {
        val first = wheelNsState.removeFirst()
        wheelNsState.addLast(first)
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val wheelArr = ArrayList<Wheel>()
    repeat(4) {
        val ns = LinkedList<Int>().apply { addAll(br.readLine().map { c -> c.digitToInt() }) }
        wheelArr.add(Wheel(it).apply { nsState = ns })
    }
    val k = br.readLine().toInt()
    repeat(k) {
        val (num, dir) = br.readLine().split(" ").map { it.toInt() }
        val q: Queue<Pair<Wheel, Int>> = LinkedList()
        val firstWheel = wheelArr[num - 1]
        firstWheel.moved = true
        q.add(Pair(firstWheel, dir))
        while (q.isNotEmpty()) {
            val (nowWheel, nowDir) = q.poll()
            val leftRightDir = if (nowDir == 1) -1 else 1
            val leftWheelNum = nowWheel.num - 1
            val rightWheelNum = nowWheel.num + 1
            // 돌린기 전 달라야 같이 돌아간다
            // 왼쪽 -> 범위 내 이고 아직 돌아가지 않았다면
            if (leftWheelNum >= 0 && !wheelArr[leftWheelNum].moved) {
                val leftWheel = wheelArr[leftWheelNum]
                // left는 두번째가 접한다
                val leftMatchNs = leftWheel.nsState[2]
                val nowWheelMatch = nowWheel.nsState[6]

                if (leftMatchNs != nowWheelMatch) {
                    leftWheel.moved = true
                    q.add(Pair(leftWheel, leftRightDir))
                }
            }

            // 오른쪽
            if (rightWheelNum < 4 && !wheelArr[rightWheelNum].moved) {
                val rightWheel = wheelArr[rightWheelNum]

                val rightMatchNs = rightWheel.nsState[6]
                val nowWheelMatch = nowWheel.nsState[2]

                if (rightMatchNs != nowWheelMatch) {
                    rightWheel.moved = true
                    q.add(Pair(rightWheel, leftRightDir))
                }
            }

            moveWheel(nowWheel, nowDir)
        }
        wheelArr.forEach {
            it.moved = false
        }
    }

    val score = wheelArr.sumOf {
        val ns = it.nsState.first
        if (ns == 1) {
            1 shl (it.num)
        }else {
            0
        }
    }

    println(score)
}