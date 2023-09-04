fun main() {
    val br = System.`in`.bufferedReader()
    val T = br.readLine().toInt()

    for (i in 1..T) {
        var N = br.readLine().toInt()
        var count = 0
        var i = 5

        while (N / i > 0) {
            count += N / i
            i *= 5
        }

        println(count)
    }
}