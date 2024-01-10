fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toLong() }

    var start = 1L
    var end = arr.max().toLong()


    while (start <= end) {
        val middle = (start + end) / 2

        val sum = arr.sumOf {
            if (it > middle) {
                it - middle
            } else {
                0
            }
        }

        if (sum >= m) {
            start = middle + 1
        } else {
            end = middle - 1
        }
    }

    println(end)
}