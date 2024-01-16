import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    val new: ArrayList<Char> = ArrayList()
    val operStack = Stack<Char>()
    val operArr = arrayOf('+', '-', '*', '/')
    for (i in str.indices) {
        val c = str[i]
        when (c) {
            in 'A'..'Z' -> {
                new.add(c)
            }
            '+', '-' -> {
                while (operStack.isNotEmpty() && operStack.peek() in operArr) {
                    new.add(operStack.pop())
                }
                operStack.add(c)
            }
            '*', '/' -> {
                while (operStack.isNotEmpty() && operStack.peek() in operArr.drop(2)) {
                    new.add(operStack.pop())
                }
                operStack.add(c)
            }
            '(' -> {
                operStack.add(c)
            }
            ')' -> {
                while (operStack.isNotEmpty() && operStack.peek() != '(') {
                    new.add(operStack.pop())
                }
                operStack.pop()
            }
        }
    }
    while (operStack.isNotEmpty()) {
        new.add(operStack.pop())
    }
    println(new.joinToString(""))
}
