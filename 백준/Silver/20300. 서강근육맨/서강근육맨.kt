fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val s = br.readLine().split(" ").map { it.toLong() }.sorted()

    var min = Long.MIN_VALUE

    if (s.size % 2 == 0) {

        for (i in 0 until s.size / 2) {
            min = maxOf(s[i] + s[s.size - i - 1], min)
        }

    } else {
        min = s.last()
        for (i in 0 until s.size / 2) {
            min = maxOf(s[i] + s[s.size - i - 2], min)
        }
    }

    println(min)
}