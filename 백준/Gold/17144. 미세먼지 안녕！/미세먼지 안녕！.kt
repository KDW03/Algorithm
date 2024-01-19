fun main() {
    val br = System.`in`.bufferedReader()
    val (R, C, T) = br.readLine().split(" ").map { it.toInt() }
    val airCleaner: ArrayList<Pair<Int, Int>> = arrayListOf()
    val arr = Array(R) { x ->
        br.readLine().split(" ").mapIndexed { y, v ->
            val num = v.toInt()
            if (num == -1) airCleaner.add(Pair(x, y))
            num
        }.toIntArray()
    }

    repeat(T) {
        diffusion(arr)
        moveAir(arr, airCleaner, R, C)
    }

    var cleanedDust = 0

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (arr[i][j] > 0) {
                cleanedDust += arr[i][j]
            }
        }
    }

    println(cleanedDust)
}

fun moveAir(arr: Array<IntArray>, airCleaner: ArrayList<Pair<Int, Int>>, R: Int, C: Int) {
    val (x1, y1) = airCleaner[0]
    val (x2, y2) = airCleaner[1]

    var pre = arr[x1][y1 + 1]
    arr[x1][y1 + 1] = 0
    for (y in y1 + 1 until C - 1) {
        val tmp = arr[x1][y + 1]
        arr[x1][y + 1] = pre
        pre = tmp
    }

    for (x in x1 downTo 1) {
        val tmp = arr[x - 1][C - 1]
        arr[x - 1][C - 1] = pre
        pre = tmp
    }

    for (y in C - 1 downTo y1 + 1) {
        val tmp = arr[0][y - 1]
        arr[0][y - 1] = pre
        pre = tmp
    }

    for (x in 0 until x1 - 1) {
        val tmp = arr[x + 1][y1]
        arr[x + 1][y1] = pre
        pre = tmp
    }

    pre = arr[x2][y2 + 1]
    arr[x2][y2 + 1] = 0
    for (y in y2 + 1 until C - 1) {
        val tmp = arr[x2][y + 1]
        arr[x2][y + 1] = pre
        pre = tmp
    }

    for (x in x2 until R - 1) {
        val tmp = arr[x + 1][C - 1]
        arr[x + 1][C - 1] = pre
        pre = tmp
    }

    for (y in C - 1 downTo y2 + 1) {
        val tmp = arr[R - 1][y - 1]
        arr[R - 1][y - 1] = pre
        pre = tmp
    }

    for (x in R - 1 downTo x2 + 2) {
        val tmp = arr[x - 1][y2]
        arr[x - 1][y2] = pre
        pre = tmp
    }
}

val moveX = arrayOf(0, 0, -1, 1)
val moveY = arrayOf(1, -1, 0, 0)

fun diffusion(arr: Array<IntArray>) {
    val diffusionArr = Array(arr.size) { IntArray(arr[0].size) }
    for (x in arr.indices) {
        for (y in arr[x].indices) {
            if (arr[x][y] >= 5){
                val canMove = ArrayList<Pair<Int, Int>>()
                for (i in 0 until 4) {
                    val nx = x + moveX[i]
                    val ny = y + moveY[i]

                    if (nx in arr.indices && ny in arr[0].indices && arr[nx][ny] != -1) canMove.add(Pair(nx, ny))
                }
                val amount = arr[x][y] / 5
                arr[x][y] = arr[x][y] - (amount) * canMove.size
                for ((cx, cy) in canMove) {
                    diffusionArr[cx][cy] += amount
                }
            }
        }
    }
    for (x in arr.indices) {
        for (y in arr[0].indices) {
            arr[x][y] += diffusionArr[x][y]
        }
    }
}