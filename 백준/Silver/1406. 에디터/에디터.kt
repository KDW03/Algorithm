import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val initialString = br.readLine()

    val n = br.readLine().toInt()

    val leftStack = Stack<Char>()
    val rightStack = Stack<Char>()

    leftStack.addAll(initialString.toList())

    repeat(n) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "L" -> if (!leftStack.isEmpty()) rightStack.push(leftStack.pop())
            "D" -> if (!rightStack.isEmpty()) leftStack.push(rightStack.pop())
            "B" -> if (!leftStack.isEmpty()) leftStack.pop()
            "P" -> leftStack.push(input[1][0])
        }
    }

    val result = StringBuilder()
    while (!leftStack.isEmpty()) {
        result.append(leftStack.pop())
    }
    result.reverse()

    while (!rightStack.isEmpty()) {
        result.append(rightStack.pop())
    }

    println(result.toString())
}
