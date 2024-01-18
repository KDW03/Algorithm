import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val (a, b) = br.readLine().split(" ").map { it.toLong()}

    val q: Queue<Pair<Long, Long>> = LinkedList()
    q.add(Pair(a, 1L))

    while (q.isNotEmpty()) {
        val (value, count) = q.poll()
        if (value == b) {
            println(count)
            return
        }
        if (value > b) continue
        q.add(Pair(value * 2, count + 1))
        q.add(Pair((value.toString() + "1").toLong(), count + 1))
    }
    println(-1)
}