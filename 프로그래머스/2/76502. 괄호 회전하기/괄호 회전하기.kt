import java.util.*
class Solution {
    fun solution(s: String): Int {
        var answer = 0
        for(i in 0 until s.length) {
            if(isCollect(s.substring(i until s.length) + s.substring(0 until i))) answer++
        }
        return answer
    }
}
    
    
    fun isCollect(s : String) : Boolean {
        val stack = Stack<Char>()
        for(c in s) {
            when(c) {
                ']' -> {
                    if(stack.empty() || stack.peek() != '[') return false
                    stack.pop()
                }
                ')' -> {
                    if(stack.empty() || stack.peek() != '(') return false
                    stack.pop()
                }
                '}' -> {
                    if(stack.empty() || stack.peek() != '{') return false
                    stack.pop()
                }
                else -> {
                    stack.push(c)
                }
            }
        }
        return stack.isEmpty()
    }
