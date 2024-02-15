fun main() {
    val br = System.`in`.bufferedReader()
    val (n, l) = br.readLine().split(" ").map { it.toInt() }

    val ba = BooleanArray(1001)
    br.readLine().split(" ").map { it.toInt() }.forEach {
        ba[it] = true
    }

    var count = 0
    for (i in ba.indices) {
        if (ba[i]) {
            for (j in i until i + l) {
                if (j !in ba.indices) break
                ba[j] = false
            }
            count++
        }
    }

    println(count)
}