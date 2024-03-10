import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    val sb = StringBuilder()
    for(i in 0 until t) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val diff = b - a
        if (diff == 0) {
            sb.append(0).append("\n")
            continue
        }
        val sqrt = sqrt(diff.toDouble()).toInt()
        val front = sqrt * sqrt
        if (front == diff) {
            sb.append(sqrt * 2 - 1).append("\n")
        } else {
            var answer = sqrt * 2
            val back : Long = (sqrt + 1) * (sqrt + 1).toLong()
            val mid = (front + back) / 2
            if (diff > mid) answer++
            sb.append(answer).append("\n")
        }
    }
    println(sb.toString())
}