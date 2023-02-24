fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, x) = br.readLine().split(" ").map { it.toInt() }
    val dkTable = Array(n) { IntArray(n) { 1000000 } }
    repeat(m) {
        val (start, dest, value) = br.readLine().split(" ").map { it.toInt() }
        dkTable[start - 1][dest - 1] = value
    }

    for (i in 0 until n) dkTable[i][i] = 0


    for (k in 0 until n) {
        for (i in 0 until n) {
            if(dkTable[i][k] != 1000000 )
            for (j in 0 until n) {
                if (i != j) {
                    dkTable[i][j] = minOf(dkTable[i][j], dkTable[i][k] + dkTable[k][j])
                }
            }
        }
    }
    var max = 0
    for ((i, value) in dkTable[x-1].withIndex()) {
        val cost = value + dkTable[i][x-1]
        if (max < cost) max = cost
    }
    println(max)
}