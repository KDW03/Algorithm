import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine()
    var answer = 0L

    val l = n.length

    for (i in l downTo 1) {

        var sum = 0
        n.forEachIndexed { index, c ->
            val num = c.digitToInt()
            sum += (if (index == 0) (num - 1) * (10.0.pow(i - 1))
            else num * (10.0.pow (i - index - 1))).toInt()
        }

        answer += (sum + 1) * i
        var tmp = ""
        repeat(i - 1) {
            tmp += "9"
        }
        n = tmp
    }

    println(answer)
}