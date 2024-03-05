import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var count = 0
    val firstWord = br.readLine()

    fun check(a: String, b: String): Boolean {
        if (abs(a.length - b.length) > 1) return false

        var aDiffCount = 0
        val aCount = a.groupingBy { it }.eachCount().toMutableMap()
        val bCount = b.groupingBy { it }.eachCount().toMutableMap()

        aCount.forEach { (t, u) ->
            aDiffCount += abs(u - bCount.getOrDefault(t, 0))
            bCount.remove(t)
        }
        if (aDiffCount > 2) return false

        val bDiffCount = bCount.values.sumOf { it }
        if (bDiffCount > 2) return false

        return aDiffCount + bDiffCount <= 2
    }

    repeat(n - 1) {
        val word = br.readLine()
        if (check(firstWord, word)) {
            count++
        }
    }

    println(count)
}

