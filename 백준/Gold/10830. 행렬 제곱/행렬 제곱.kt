fun main() {
    val br = System.`in`.bufferedReader()
    val (n, b) = br.readLine().split(" ").map { it.toLong() }
    val matrix = Array(n.toInt()) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    matrixPower(matrix, b).forEach { row ->
        println(row.map { it % 1000 }.joinToString(" "))
    }
}

fun matrixPower(matrix: Array<IntArray>, power: Long): Array<IntArray> {
    if (power == 1L) return matrix

    if (power % 2L == 1L) return matrixMultiply(matrixPower(matrix, power - 1), matrix)

    val halfPower = matrixPower(matrix, power / 2)
    return matrixMultiply(halfPower, halfPower)
}

fun matrixMultiply(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> {
    val size = mat1.size
    val result = Array(size) { IntArray(size) }
    for (i in 0 until size) {
        for (j in 0 until size) {
            for (k in 0 until size) {
                result[i][j] = (result[i][j] + mat1[i][k] * mat2[k][j]) % 1000
            }
        }
    }
    return result
}