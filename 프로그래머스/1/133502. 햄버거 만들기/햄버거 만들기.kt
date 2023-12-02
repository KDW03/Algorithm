import java.util.*

class Solution {
    fun solution(ingredient: IntArray): Int {
    var count = 0
    val stack = Stack<Int>()

    for (ing in ingredient) {
        stack.push(ing)
        if (stack.size >= 4 && stack[stack.size - 1] == 1 && stack[stack.size - 2] == 3 && stack[stack.size - 3] == 2 && stack[stack.size - 4] == 1) {
            for (i in 0 until 4) stack.pop()
            count++ 
        }
    }

    return count 
}

}