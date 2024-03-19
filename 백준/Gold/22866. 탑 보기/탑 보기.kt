import java.util.Stack
import kotlin.math.abs

data class Building(val idx: Int, val height: Int)

fun main() {
    // 예제 입력
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val buildings = br.readLine().split(" ").mapIndexed { i, h ->
        Building(i + 1, h.toInt())
    }

    val stack = Stack<Building>()
    val answer = Array(n) { Pair(0, 0) }


    for ((i, h) in buildings) {

        while (!stack.isEmpty() && stack.peek().height <= h) {
            stack.pop()
        }

        val c = stack.size
        if (c != 0) answer[i - 1] = Pair(c, stack.peek().idx)
        stack.push(Building(i, h))
    }
    
    stack.clear()

    for ((i, h) in buildings.reversed()) {

        while (!stack.isEmpty() && stack.peek().height <= h) {
            stack.pop()
        }

        val c = stack.size

        if (c != 0) {
            val (count, near) = answer[i - 1]
            val a = if (near == 0) Int.MAX_VALUE else abs(i - near)
            val b = abs(i - stack.peek().idx)
            val totalNear = if (a <= b) near else stack.peek().idx
            answer[i - 1] = Pair(count + c, totalNear)
        }

        stack.push(Building(i, h))
    }

    val sb = java.lang.StringBuilder()
    answer.forEach {
        if (it.first == 0) sb.append(0)
        else sb.append("${it.first} ${it.second}")
        sb.append("\n")
    }

    println(sb.toString().trimEnd())
}