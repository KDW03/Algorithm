import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sick = br.readLine()
    val arr = IntArray(n) {
        br.readLine().toInt()
    }

    val stack = Stack<Double>()
    for (t in sick) {
        when(t) {
            '+' -> {
                val result = stack.pop() + stack.pop()
                stack.add(result)
            }
            '-' -> {
                val a = stack.pop()
                val b = stack.pop()
                stack.add(b - a)
            }
            '*' -> {
                stack.add(stack.pop() * stack.pop())
            }
            '/' -> {
                val a = stack.pop()
                val b = stack.pop()
                stack.add(b / a)
            }
            else -> {
                val idx = t - 'A'
                stack.add(arr[idx].toDouble())
            }
        }
    }
    val answer = stack.pop()
    println(String.format("%.2f",answer))
}
