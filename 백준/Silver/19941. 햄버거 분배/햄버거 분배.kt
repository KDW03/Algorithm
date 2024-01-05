fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    var count = 0
    val list = br.readLine().toMutableList()

    list.forEachIndexed { index, c ->

        if (c == 'P') {

            for (i in maxOf(0, index - k)..minOf(index + k, list.size - 1)) {
                if (list[i] == 'H') {
                    list[i] = 'E'
                    count++
                    break
                }
            }

        }

    }
    println(count)
}