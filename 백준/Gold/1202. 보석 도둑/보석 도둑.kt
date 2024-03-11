import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val jewels = ArrayList<Pair<Int, Int>>(n)
    for (i in 0 until n) {
        val (m, v) = br.readLine().split(' ').map { it.toInt() }
        jewels.add(m to v)
    }
    val bags = Array(k) { br.readLine().toInt() }

    jewels.sortBy { it.first } // 무게에 따라 오름차순 정렬
    bags.sort() // 가방도 무게에 따라 오름차순 정렬

    val pq = PriorityQueue<Int>(reverseOrder()) // 가격을 기준으로 내림차순 정렬하는 우선순위 큐
    var result: Long = 0
    var jIndex = 0

    for (bag in bags) {
        while (jIndex < n && jewels[jIndex].first <= bag) {
            pq.add(jewels[jIndex].second)
            jIndex++
        }
        if (pq.isNotEmpty()) {
            result += pq.poll()
        }
    }

    println(result)
}
