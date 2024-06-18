import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val stack = Stack<Pair<Int, Int>>()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val answer = IntArray(n) { -1 }

    for ((i, value) in nums.withIndex()) {
        while (stack.isNotEmpty() && stack.peek().second < value) {
            val (ni, nValue) = stack.pop()
            answer[ni] = value
        }
        stack.push(Pair(i, value))
    }

    println(answer.joinToString(" "))
}