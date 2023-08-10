import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val firstQueue: Deque<Int> = LinkedList(queue1.toList())
        val secondQueue: Deque<Int> = LinkedList(queue2.toList())

        val limit = queue1.size * 4
        var answer = 0

        var firstQueueSum = firstQueue.sum().toLong()
        var secondQueueSum = secondQueue.sum().toLong()
        val total : Long = firstQueueSum + secondQueueSum
        if(total % 2L != 0L) return -1


        while (true) {
            if (answer >= limit) return -1

            if (firstQueueSum == secondQueueSum) return answer

            if (firstQueueSum > secondQueueSum) {
                val poll = firstQueue.pollFirst()
                secondQueue.addLast(poll)
                secondQueueSum += poll
                firstQueueSum -= poll
            } else {
                val poll = secondQueue.pollFirst()
                firstQueue.addLast(poll)
                firstQueueSum += poll
                secondQueueSum -= poll
            }
            answer++
        }
        return -1
    }
}