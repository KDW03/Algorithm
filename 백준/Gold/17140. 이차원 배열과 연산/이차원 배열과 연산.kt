fun main() {
    val br = System.`in`.bufferedReader()

    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }

    val horizontalArr = Array(100) { IntArray(100) }
    val verticalArr = Array(100) { IntArray(100) }

    var nr = 3
    var nc = 3

    for (x in 0 until 3) {
        val input = br.readLine().split(" ").map { it.toInt() }
        input.forEachIndexed { y, num ->
            horizontalArr[x][y] = num
            verticalArr[y][x] = num
        }
    }


    var time = 0
    while (time <= 100) {

        if (horizontalArr[r - 1][c - 1] == k) {
            println(time)
            return
        }

        time++

        if (nr >= nc) {
            // 모든 행에 대해서
            for (x in 0 until nr) {

                val sorted = horizontalArr[x].toList().groupingBy { it }.eachCount().toList()
                    .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

                for (y in 0 until 100) {
                    horizontalArr[x][y] = 0
                    verticalArr[y][x] = 0
                }

                for (i in sorted.indices) {
                    val (a, b) = sorted[i]
                    if (a == 0) continue
                    val start = i * 2
                    // 100개보다 많다면 자르기
                    if (start + 1 >= 100) break
                    horizontalArr[x][start] = a
                    verticalArr[start][x] = a
                    horizontalArr[x][start + 1] = b
                    verticalArr[start + 1][x] = b
                    nc = maxOf(nc, start + 2)
                }
            }
        } else {
            for (x in 0 until nc) {
                val sorted = verticalArr[x].toList().groupingBy { it }.eachCount().toList()
                    .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

                for (y in 0 until 100) {
                    verticalArr[x][y] = 0
                    horizontalArr[y][x] = 0
                }

                for (i in sorted.indices) {
                    val (a, b) = sorted[i]
                    if (a == 0) continue
                    val start = i * 2
                    // 100개보다 많다면 자르기
                    if (start + 1 >= 100) break
                    verticalArr[x][start] = a
                    horizontalArr[start][x] = a
                    verticalArr[x][start + 1] = b
                    horizontalArr[start + 1][x] = b
                    nr = maxOf(nr, start + 2)
                }
            }
        }
    }


    println(-1)
}