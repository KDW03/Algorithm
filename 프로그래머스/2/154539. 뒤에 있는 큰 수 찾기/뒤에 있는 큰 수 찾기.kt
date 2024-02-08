import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val n = numbers.size
        val answer = IntArray(n) { -1 }
        
        // stack에 있는것보다 뒤에 있는 크다면
        // stack pop해서 그 위치에 뒤에 있는 값 넣어주기
        val stack = Stack<Int>()
        
        // n
        for(i in numbers.indices) {
            val num = numbers[i]
            while(stack.isNotEmpty() && numbers[stack.peek()] < num) {
                answer[stack.pop()] = num
            }
            stack.push(i)
        }

        return answer
    }
}
