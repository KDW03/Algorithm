import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val stk = Stack<String>()
    val input = br.readLine().run {
        replace("()", "1")
    }

    var anwer = 0L
    for (char in input) {
        val c = char.toString()
        if (c == ")") {
            var count = 0L
            while (stk.peek() != "(") {
                count += stk.pop().toLong()
            }; stk.pop()
            anwer += (count + 1)
            if (stk.contains("(")) stk.push(count.toString())
        }else{
            stk.push(char.toString())
        }
    }
    println(anwer)
}
