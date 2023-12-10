import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x > y) return -1

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visited = HashSet<Int>()
        queue.add(Pair(x, 0))

        while (queue.isNotEmpty()) {
            val (current, count) = queue.poll()

            if (current == y) return count
            if (current > y || visited.contains(current)) continue

            visited.add(current)
            queue.add(Pair(current + n, count + 1))
            queue.add(Pair(current * 2, count + 1))
            queue.add(Pair(current * 3, count + 1))
        }

        return -1
    }
}