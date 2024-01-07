fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val leftCount = br.readLine().split(" ").map { it.toInt() }
    val line = IntArray(N)

    for (i in 1..N) {
        var count = leftCount[i - 1]
        for (j in 0 until N) {
            if (count == 0 && line[j] == 0) {
                line[j] = i
                break
            } else if (line[j] == 0) {
                count--
            }
        }
    }

    println(line.joinToString(" "))
}
