fun main() {
    val br = System.`in`.bufferedReader()
    val (a, b) = br.readLine().split(" ").map { it.toLong() }
    println(ca(b) - ca(a - 1))
}

fun ca(x: Long): Long {
    if (x <= 0) return 0

    var num = 1L
    var i = 0
    while (num <= x / 2) {
        i++
        num *= 2
    }

    if (num == x) return i * x / 2 + 1

    val diff = x - num
    return ca(num) + diff + ca(diff)
}
