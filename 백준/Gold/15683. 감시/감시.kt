data class CCTV(val num: Int, val x: Int, val y: Int)
enum class Direction {
    L, R, U, D
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val cctvs = ArrayList<CCTV>()
    var wallCount = 0
    val arr = Array(n) { x ->
        br.readLine().split(" ").mapIndexed { y, it ->
            val num = it.toInt()
            if (num in 1..5) cctvs.add(CCTV(num, x, y))
            if (num == 6) wallCount++
            num
        }.toIntArray()
    }
    var max = Int.MIN_VALUE
    fun dfs(arr: Array<IntArray>, cctvs: ArrayList<CCTV>, idx: Int = 0, count: Int = 0) {
        if (cctvs.size == idx) {
            max = maxOf(max, count)
            return
        }
        val nowCCTV = cctvs[idx]
        val x = nowCCTV.x
        val y = nowCCTV.y
        when (nowCCTV.num) {
            1 -> {
                val newArr = arr.map { it.copyOf() }.toTypedArray()
                val newCount = count + move(newArr, x, y, Direction.L)
                dfs(newArr, cctvs, idx + 1, newCount)

                val newArr2 = arr.map { it.copyOf() }.toTypedArray()
                val newCount2 = count + move(newArr2, x, y, Direction.R)
                dfs(newArr2, cctvs, idx + 1, newCount2)

                val newArr3 = arr.map { it.copyOf() }.toTypedArray()
                val newCount3 = count + move(newArr3, x, y, Direction.U)
                dfs(newArr3, cctvs, idx + 1, newCount3)

                val newArr4 = arr.map { it.copyOf() }.toTypedArray()
                val newCount4 = count + move(newArr4, x, y, Direction.D)
                dfs(newArr4, cctvs, idx + 1, newCount4)
            }
            2 -> {
                val newArr = arr.map { it.copyOf() }.toTypedArray()
                val newCount = count + move(newArr, x, y, Direction.L) + move(newArr, x, y, Direction.R)
                dfs(newArr, cctvs, idx + 1, newCount)

                val newArr2 = arr.map { it.copyOf() }.toTypedArray()
                val newCount2 = count + move(newArr2, x, y, Direction.U) + move(newArr2, x, y, Direction.D)
                dfs(newArr2, cctvs, idx + 1, newCount2)
            }
            3 -> {
                val newArr = arr.map { it.copyOf() }.toTypedArray()
                val newCount = count + move(newArr, x, y, Direction.U) + move(newArr, x, y, Direction.R)
                dfs(newArr, cctvs, idx + 1, newCount)

                val newArr2 = arr.map { it.copyOf() }.toTypedArray()
                val newCount2 = count + move(newArr2, x, y, Direction.R) + move(newArr2, x, y, Direction.D)
                dfs(newArr2, cctvs, idx + 1, newCount2)

                val newArr3 = arr.map { it.copyOf() }.toTypedArray()
                val newCount3 = count + move(newArr3, x, y, Direction.D) + move(newArr3, x, y, Direction.L)
                dfs(newArr3, cctvs, idx + 1, newCount3)

                val newArr4 = arr.map { it.copyOf() }.toTypedArray()
                val newCount4 = count + move(newArr4, x, y, Direction.L) + move(newArr4, x, y, Direction.U)
                dfs(newArr4, cctvs, idx + 1, newCount4)
            }
            4 -> {
                val newArr = arr.map { it.copyOf() }.toTypedArray()
                val newCount = count + move(newArr, x, y, Direction.L)+move(newArr, x, y, Direction.U)+move(newArr, x, y, Direction.R)
                dfs(newArr, cctvs, idx + 1, newCount)

                val newArr2 = arr.map { it.copyOf() }.toTypedArray()
                val newCount2 = count + move(newArr2, x, y, Direction.U) + move(newArr2, x, y, Direction.R) + move(newArr2, x, y, Direction.D)
                dfs(newArr2, cctvs, idx + 1, newCount2)

                val newArr3 = arr.map { it.copyOf() }.toTypedArray()
                val newCount3 = count + move(newArr3, x, y, Direction.R) + move(newArr3, x, y, Direction.D) + move(newArr3, x, y, Direction.L)
                dfs(newArr3, cctvs, idx + 1, newCount3)

                val newArr4 = arr.map { it.copyOf() }.toTypedArray()
                val newCount4 = count + move(newArr4, x, y, Direction.D) + move(newArr4, x, y, Direction.L) + move(newArr4, x, y, Direction.U)
                dfs(newArr4, cctvs, idx + 1, newCount4)
            }
            5 -> {
                val newArr = arr.map { it.copyOf() }.toTypedArray()
                val newCount = count + move(newArr, x, y, Direction.L)+move(newArr, x, y, Direction.U)+move(newArr, x, y, Direction.R)  + move(newArr, x, y, Direction.D)
                dfs(newArr, cctvs, idx + 1, newCount)
            }
        }
    }

    dfs(arr, cctvs)

    println((n * m) - (max + cctvs.size + wallCount))
}

fun inScope(x: Int, y: Int, xScope: Int, yScope: Int): Boolean = x in 0 until xScope && y in 0 until yScope

val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(1, -1, 0, 0)
fun move(arr: Array<IntArray>, x: Int, y: Int, dir: Direction): Int {
    val xScope = arr.size
    val yScope = arr[0].size
    var count = 0
    when (dir) {
        Direction.L -> {
            var ny = y + moveY[1]
            while (inScope(x, ny, xScope, yScope) && arr[x][ny] != 6) {
                if (arr[x][ny] == 0) {
                    arr[x][ny] = -1
                    count++
                }
                ny += moveY[1]
            }
        }
        Direction.R -> {
            var ny = y + moveY[0]
            while (inScope(x, ny, xScope, yScope) && arr[x][ny] != 6) {
                if (arr[x][ny] == 0) {
                    arr[x][ny] = -1
                    count++
                }
                ny += moveY[0]
            }
        }
        Direction.U -> {
            var nx = x + moveX[2]
            while (inScope(nx, y, xScope, yScope) && arr[nx][y] != 6) {
                if (arr[nx][y] == 0) {
                    arr[nx][y] = -1
                    count++
                }
                nx += moveX[2]
            }
        }
        Direction.D -> {
            var nx = x + moveX[3]
            while (inScope(nx, y, xScope, yScope) && arr[nx][y] != 6) {
                if (arr[nx][y] == 0) {
                    arr[nx][y] = -1
                    count++
                }
                nx += moveX[3]
            }
        }
    }
    return count
}