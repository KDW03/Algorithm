import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val stack : Stack<Char> = Stack()

    val str = br.readLine()
    val sb = StringBuilder()
    var i = 0
    while(i in str.indices) {
        when(str[i]) {
            '<' -> {
                pollAll(stack,sb)
                sb.append('<')
                i++
                while (i in str.indices) {
                    val c = str[i]
                    if (c == '>') {
                        sb.append('>')
                        break
                    }
                    sb.append(c)
                    i++
                }

            }
            ' ' -> {
                pollAll(stack,sb)
                sb.append(' ')
            }
            else -> {
                stack.push(str[i])
            }
        }
        i++
    }

    pollAll(stack,sb)

    println(sb.toString())
}

fun pollAll(stack: Stack<Char>,sb : StringBuilder) {
    while (stack.isNotEmpty()) {
        sb.append(stack.pop())
    }
}
