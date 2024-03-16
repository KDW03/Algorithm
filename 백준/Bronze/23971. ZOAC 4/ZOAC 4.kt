fun main() {
    val br = System.`in`.bufferedReader()
    val (h, w, n, m) = br.readLine().split(" ").map { it.toInt() }

    val rows = h / (n + 1) + if (h % (n + 1) > 0) 1 else 0
    val columns = w / (m + 1) + if (w % (m + 1) > 0) 1 else 0

    println(rows * columns)
}
