import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val maxHeap: PriorityQueue<Int> = PriorityQueue(
        compareBy({
            Math.abs(it)
        }, { it })
    )
    val sb = StringBuilder()
    repeat(n) {
        val num = br.readLine().toInt()
        if (num == 0) {

            if (maxHeap.isEmpty()) {
                sb.append(0).append("\n")
            } else {
                sb.append(maxHeap.poll()).append("\n")
            }

        } else {
            maxHeap.add(num)
        }
    }

    println(sb.toString())
}