data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()

    //  N은 별똥별이 떨어지는 구역의 가로길이, M은 세로길이
    //  L은 트램펄린의 한 변의 길이, K는 별똥별의 수를 뜻한다.
    val (n, m, l, k) = br.readLine().split(" ").map { it.toInt() }

    val points = Array(k) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        Point(x, y)
    }

    var answer = 0

    val xSet = points.map { it.x }.toSet()
    val ySet = points.map { it.y }.toSet()

    fun checkCount(xRange: IntRange, yRange: IntRange): Int = points.count { it.x in xRange && it.y in yRange }

    for (x in xSet) {
        for (y in ySet) {
            val xRange = x..x + l
            val yRange = y..y + l
            answer = maxOf(checkCount(xRange, yRange), answer)
        }
    }

    println(k - answer)
}