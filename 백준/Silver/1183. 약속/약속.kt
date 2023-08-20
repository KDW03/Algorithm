import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val timeArr = IntArray(n)

    if (n % 2 == 1) {
        println(1)
        return
    }

    repeat(n) { idx ->
        br.readLine().split(" ").map { it.toInt() }.let {
            timeArr[idx] = it[1] - it[0]
        }
    }

    timeArr.sort()

    println(abs(timeArr[n/2] - timeArr[n/2 -1]) + 1)

}