import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {

        val answer = ArrayList<Int>()

        var flag = true
        operations.forEach { operation ->

            val (cmd, num) = operation.split(" ")
            when (cmd) {
                "I" -> {
                    answer.add(num.toInt())
                    flag = false
                }

                "D" -> {
                    if(flag == false) {
                        answer.sort()
                        flag = true
                    }
                    if (num == "1" && answer.isNotEmpty()) answer.removeLast()
                    if (num == "-1" && answer.isNotEmpty()) answer.removeFirst()
                }
            }
        }
        
        if(flag == false) {
            answer.sort()
            flag = true
        }
        return intArrayOf(answer.lastOrNull() ?: 0, answer.firstOrNull() ?: 0)
    }
}