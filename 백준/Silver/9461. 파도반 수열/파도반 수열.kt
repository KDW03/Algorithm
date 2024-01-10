fun main() {
    val br = System.`in`.bufferedReader()
    val p = LongArray(101)

    for (i in 1 until 4) {
        p[i] = 1
    }

    for (i in 4 until p.size) {
        p[i] = p[i - 2] + p[i - 3]
    }

    val sb = StringBuilder()
    repeat(br.readLine().toInt()) {
        sb.append(p[br.readLine().toInt()]).append("\n")
    }

    println(sb.toString())
}
