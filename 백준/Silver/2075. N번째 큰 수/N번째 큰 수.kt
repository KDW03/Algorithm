import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val pq: PriorityQueue<Int> = PriorityQueue()

    repeat(n) {
        pq.addAll(br.readLine().split(" ").map { it.toInt() })
        while (pq.size > n) {
            pq.poll()
        }
    }

    println(pq.poll())
}