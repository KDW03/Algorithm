import java.util.*

class Solution {
        fun solution(numbers: IntArray): IntArray {
            val result = IntArray(numbers.size) { -1 }
            val stack : Stack<Int> = Stack<Int>() 

            for (i in numbers.indices) {

                while (stack.isNotEmpty() && numbers[stack.peek()] < numbers[i]) {
                    result[stack.pop()] = numbers[i]
                }

                stack.push(i)
            }
        return result
    }
}