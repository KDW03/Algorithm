fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { IntArray(n) }

    repeat(n) {
        arr[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                arr[i][j] = maxOf((arr[i][k] + arr[k][j]) / 2, arr[i][j])
            }
        }
    }

    arr.forEach {
        println(it.joinToString(" "))
    }


}