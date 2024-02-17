import java.util.*
class Solution {
    fun solution(number: String, k: Int): String {
        val stack = Stack<Char>()
        var count =0
        for(c in number) {
            while(stack.isNotEmpty() && count < k &&c > stack.peek()) {
                stack.pop()
                count++
            }
            stack.add(c)
        }
        
        return stack.toList().joinToString("").take(number.length - k)
    }
}