import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    // 정수 1은 익은 토마토
    // 정수 0 은 익지 않은 토마토
    // 정수 -1은 토마토 x

    val (n, m, h) = br.readLine().split(" ").map { it.toInt() }

    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    var flag = true
    val arr = Array(m * h) { x ->
        br.readLine().split(" ").mapIndexed { y, it ->
            val tmp = it.toInt()
            if (tmp == 1) q.add(Triple(x, y, 0))
            if (tmp == 0) flag = false
            tmp
        }.toIntArray()
    }


    if (flag) {
        println(0)
        return
    }

    val moveX = arrayOf(-1, 1, 0, 0, -m, m)
    val moveY = arrayOf(0, 0, 1, -1, 0, 0)

    while (q.isNotEmpty()) {
        val (x, y, day) = q.poll()

        for (i in 0 until 4) {
            val th = x / m
            val nx = x + moveX[i]
            val ny = y + moveY[i]
            // 현재보다 day가 작다면
            if (nx in th * m until (th + 1) * m && ny in arr[0].indices) {
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = day + 1
                    q.add(Triple(nx, ny, day + 1))
                } else if (arr[nx][ny] > 0 && arr[nx][ny] > day + 1) {
                    arr[nx][ny] = day + 1
                    q.add(Triple(nx, ny, day + 1))
                }
            }
        }

        for (i in 4 until 6) {
            val nx = x + moveX[i]
            val ny = y + moveY[i]

            if (nx in arr.indices && ny in arr[0].indices) {
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = day + 1
                    q.add(Triple(nx, ny, day + 1))
                } else if (arr[nx][ny] > 0 && arr[nx][ny] > day + 1) {
                    arr[nx][ny] = day + 1
                    q.add(Triple(nx, ny, day + 1))
                }
            }
        }
    }

    var max = Int.MIN_VALUE

    for (i in arr.indices) {
        for (j in arr[0].indices) {
            if (arr[i][j] == 0) {
                println(-1)
                return
            }
            max = maxOf(max, arr[i][j])
        }
    }

    println(max)
}
