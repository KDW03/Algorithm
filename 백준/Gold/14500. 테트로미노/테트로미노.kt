fun main() {
    val br = System.`in`.bufferedReader()
    val tetromino = arrayOf(
        arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3)),  // I 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 0)),  // I 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 0)),  // L 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(2, 1)),  // L 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2)),  // L 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(2, -1)), // L 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(1, 2)),  // T 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(1, -1), intArrayOf(1, -2)), // T 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(2, 0)),  // T 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(2, 1)),  // T 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1)),  // O 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(-1, 1)), // S 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(1, 1)),  // S 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 1)),  // Z 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(2, 1)),  // Z 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(1, 2)),  // J 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(1, 2)),  // J 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, -1)), // J 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(-1, 2)), // J 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(1, -1), intArrayOf(2, -1)), // J 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1)),  // L 형태
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, -1)), // L 형태
        arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(1, -1))  // L 형태
    )
    
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    var max = Int.MIN_VALUE

    for (x in arr.indices) {
        for (y in arr[0].indices) {
            outer@ for (k in tetromino) {
                var sum = arr[x][y]
                for (t in k) {
                    val nx = x + t[0]
                    val ny = y + t[1]
                    if (nx in 0 until n && ny in 0 until m) {
                        sum += arr[nx][ny]
                    } else {
                        continue@outer
                    }
                }
                max = maxOf(sum, max)
            }
        }
    }

    println(max)
}