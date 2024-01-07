fun power(a: Long, b: Long, c: Long): Long = when {
    b == 0L -> 1
    else -> {
        val t = power(a, b / 2, c)
        val result = (t * t) % c
        if (b % 2 == 0L) result else (result * a) % c
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (a, b, c) = br.readLine().split(" ").map { it.toLong() }

    println(power(a, b, c))
}