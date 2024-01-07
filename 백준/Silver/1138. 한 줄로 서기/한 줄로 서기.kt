import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val leftCounts = br.readLine().split(" ").map { it.toInt() }
    val lineup = ArrayList<Int>(Collections.nCopies(N, 0))

    for (i in N - 1 downTo 0) {
        lineup.add(leftCounts[i], i + 1)
    }

    println(lineup.take(N).joinToString(" "))
}
