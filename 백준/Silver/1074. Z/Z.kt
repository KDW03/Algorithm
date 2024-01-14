fun findPosition(n: Int, x: Int, y: Int): Int {
    var answer = 0
    var r = x
    var c = y
    var size = 1 shl n

    while (size > 1) {
        size = size shr 1
        val half = size * size

        if (r >= size) {
            answer += half * 2
            r -= size
        }
        if (c >= size) {
            answer += half
            c -= size
        }
    }
    return answer
}

fun main() {
    val br= System.`in`.bufferedReader()
    val (N, r, c) = br.readLine().split(' ').map { it.toInt() }
    println(findPosition(N, r, c))
}
