import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var count = 0
    repeat(n) {
        val stack = Stack<Char>()
        br.readLine().forEach {
            if (stack.isNotEmpty()) {
                val last = stack.peek()
                if (last == it) stack.pop()
                else stack.push(it)
            } else {
                stack.add(it)
            }
        }
        if (stack.isEmpty()) count++
    }
    println(count)
}