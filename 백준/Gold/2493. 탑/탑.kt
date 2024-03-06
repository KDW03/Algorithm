import java.util.Stack

data class Top(val idx: Int, val height: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val tops = br.readLine().split(" ").mapIndexed { i, height ->
        Top(i + 1, height.toInt())
    }
    val answer = IntArray(n)
    val stack = Stack<Top>()
    stack.add(tops.last())
    for (i in tops.size - 2 downTo 0) {
        val (idx,height) = tops[i]
        while (stack.isNotEmpty() && height >= stack.peek().height) {
            val (p,v) = stack.pop()
            answer[p - 1] = idx
        }
        stack.add(tops[i])
    }
    println(answer.joinToString(" "))
}