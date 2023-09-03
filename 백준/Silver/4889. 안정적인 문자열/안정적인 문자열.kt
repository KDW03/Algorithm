import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    var idx = 1
    while (true) {
        val str = br.readLine()
        if (str.contains("-")) break

        var count = 0
        val stack: Stack<Char> = Stack()
        str.forEach {
            when (it) {
                '}' -> {
                    if (stack.isEmpty()){
                        stack.add('{')
                        count++
                    }else{
                        stack.pop()
                    }
                }

                '{' -> {
                    stack.add(it)
                }
            }
        }

        if (stack.isNotEmpty()){
            count += stack.size / 2
        }

        println("${idx++}. $count")
    }
}
