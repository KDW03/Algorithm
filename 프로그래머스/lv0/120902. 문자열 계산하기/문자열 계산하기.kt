import java.util.*

class Solution {
    fun solution(my_string: String): Int {
        val stk: Stack<String> = Stack()
        val st = my_string.trim().split(" ")
        stk.addAll(st.reversed())
        while (stk.size != 1) {
            val first = stk.pop().toInt()
            val oper = stk.pop()
            val two = stk.pop().toInt()
            println("${first} ${oper} ${two} = ${add(first,two, oper)}")
            stk.push(add(first, two, oper).toString())
        }
        return stk.pop().toInt()
    }

    private fun add(first: Int, two: Int, oper: String): Int {
        return when (oper) {
            "+" -> first + two
            else -> first - two
        }
    }
}