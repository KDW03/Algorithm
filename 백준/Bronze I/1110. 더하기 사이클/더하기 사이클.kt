fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()


    var l: Long = 0L
    var now = n
    while (true) {
        l++
        if (now.length == 1) now = "0$now"

        // 자릿수 각 합
        var sum = 0
        now.forEach {
            sum += it.digitToInt()
        }

        now = "" + now.last() + sum.toString().last()
        if (now.toInt() == n.toInt()) break
    }

    println(l)
}