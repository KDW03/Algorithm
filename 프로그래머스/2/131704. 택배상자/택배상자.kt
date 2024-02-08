import java.util.*

class Solution {
    fun solution(order: IntArray): Int {

        val n = order.size
        val stack = Stack<Int>()
        val q : Queue<Int> = LinkedList<Int>().apply { addAll((1..n).toList()) }

        // 현재 트럭에 넣어야 하는거
        var count = 0
        for(now in order) {
            // 메인에서 꺼낸게 현재 order 보다 작다면 메인에서 아직 안나옴
            while(q.isNotEmpty() && q.peek() < now) {
                stack.add(q.poll())
            }

            // 메인이나 보조에서 꺼내서 order에 맞출수 없다면 멈춤
            if(q.peek() == now) q.poll()
            else if(stack.peek() == now) stack.pop()
            else {
                break
            }
            count++
        }
        return count
    }
}