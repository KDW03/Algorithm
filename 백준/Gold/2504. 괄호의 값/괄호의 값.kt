import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val input = br.readLine()
    val stack = Stack<Int>()

    var result = 0
    var temp = 1
    var flag = true

    for (i in input.indices) {
        when (input[i]) {
            '(' -> {
                stack.push(i)
                temp *= 2
            }
            '[' -> {
                stack.push(i)
                temp *= 3
            }
            ')' -> {
                if (stack.isEmpty() || input[stack.peek()] != '(') {
                    flag = false
                    break
                }
                if (input[i - 1] == '(') result += temp
                stack.pop()
                temp /= 2
            }
            ']' -> {
                if (stack.isEmpty() || input[stack.peek()] != '[') {
                    flag = false
                    break
                }
                if (input[i - 1] == '[') result += temp
                stack.pop()
                temp /= 3
            }
        }
    }

    if (!stack.isEmpty()) flag = false
    println(if (flag) result else 0)
}
