import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    while (true) {
        val str = br.readLine() ?: break
        if (str == ".") {
            break
        }
        println(if (isValidParentheses(str)) "yes" else "no")
    }
}

fun isValidParentheses(str: String): Boolean {
    val stack = Stack<Char>()
    for (ch in str) {
        when (ch) {
            '(', '[' -> stack.push(ch)
            ')' -> {
                if (stack.isNotEmpty() && stack.peek() == '(') {
                    stack.pop()
                } else {
                    return false
                }
            }
            ']' -> {
                if (stack.isNotEmpty() && stack.peek() == '[') {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
    }
    return stack.isEmpty()
}
