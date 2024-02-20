import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val al = ArrayList<Int>()
    repeat(n) {
        al.add(br.readLine().toInt())
    }

    var sum = 0L
    al.sorted().forEachIndexed { i, v ->
        sum += abs(i+1 - v)
    }

    println(sum)
}