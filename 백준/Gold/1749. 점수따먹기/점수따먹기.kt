fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val matrix = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        matrix[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val prefixSum = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            prefixSum[i][j] = matrix[i][j] + if (j > 0) prefixSum[i][j - 1] else 0
        }
    }

    var maxSum = Int.MIN_VALUE
    for (startCol in 0 until m) {
        for (endCol in startCol until m) {
            var tempSum = 0
            for (row in 0 until n) {
                val colSum = prefixSum[row][endCol] - if (startCol > 0) prefixSum[row][startCol - 1] else 0
                tempSum = if (tempSum > 0) tempSum + colSum else colSum
                maxSum = maxOf(maxSum, tempSum)
            }
        }
    }
    
    println(maxSum)
}
