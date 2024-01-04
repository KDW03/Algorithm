import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()

    val (N,M) = br.readLine().split(" ").map { it.toInt() }
    val j = br.readLine().toInt()

    var left = 1
    var right = M
    var answer = 0
    repeat(j) {

        val apple = br.readLine().toInt()

        if (apple < left) {
            answer += abs(left - apple)
            left = apple
            right = left + M - 1
        }
        if (apple > right) {
            answer += abs(right - apple)
            right = apple
            left = right - M + 1
        }
    }

    println(answer)
}