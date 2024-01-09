fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr: Array<IntArray> = Array(n + 1) { IntArray(n + 1) { 100000 } }

    for (i in 1..n) {
        arr[i][i] = 0
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        arr[a][b] = 1
        arr[b][a] = 1
    }


    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                arr[i][j] = minOf(arr[i][j], arr[i][k] + arr[k][j])
            }
        }
    }

    var min = Int.MAX_VALUE

    arr.drop(1).forEachIndexed { index, ints ->
        arr[index + 1][0] = ints.drop(1).sum()
        min = minOf(min,arr[index + 1][0])
    }

    println(arr.indexOfFirst { it[0] == min })
}