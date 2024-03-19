fun main() {
    val br = System.`in`.bufferedReader()
    var (n,a,b) = br.readLine().split(" ").map { it.toInt() }
    // 6 > 5
    if (a + b > n + 1) {
        println(-1)
        return
    }

    val sb = StringBuilder()
    if (a > b) {
        b--
        // 뒤에 있는게 더 크다면
    } else {
        a--
    }

    val remain = n - (a + b)

    if (a == 0) {

        sb.append("$b ")
        b--
        repeat(remain) {
            sb.append("1 ")
        }
        for (i in 1 .. a) sb.append("$i ")
        for (i in b downTo 1) sb.append("$i ")
    } else {
        repeat(remain) {
            sb.append("1 ")
        }
        for (i in 1 .. a) sb.append("$i ")
        for (i in b downTo 1) sb.append("$i ")
    }

    println(sb.toString().trimEnd())
}