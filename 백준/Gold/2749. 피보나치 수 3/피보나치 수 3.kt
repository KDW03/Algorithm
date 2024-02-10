const val MOD = 1000000


/**
 * 피사노 주기는 피보나치 수열을 어떤수 M으로 나눈 나머지가 반복되는 주기
 * 처음 두항인 0과 1로 오는 곳 찾으면 됌
 */
fun calculatePisano(n: Long): Long? {
    var prePre = 0L
    var pre = 1L

    for (i in 2 until n) {
        val now = (prePre + pre) % MOD
        prePre = pre
        pre = now
        if (prePre == 0L && pre == 1L) return i - 1
    }

    return null
}


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()

    var pisanoPeriod = calculatePisano(n) ?: (n + 1)
    val nModePisano = n % pisanoPeriod

    println(fibonacci(nModePisano))
}

fun fibonacci(n: Long): Long {
    if (n <= 1L) return n

    var prePre = 0L
    var pre = 1L
    for (i in 2 .. n) {
        val now = (prePre + pre) % MOD
        prePre = pre
        pre = now
    }

    return pre
}


