data class Point(val x: Int = 0, val y: Int = 0)

enum class DIR(val dirInt: Int) {
    U(0), D(1), R(2), L(3)
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var count = 0
    var mPoint = Point()
    val arr = Array(n) { x ->
        br.readLine().mapIndexed { y, c ->
            if (c == 'M') mPoint = Point(x, y)
            else if (c != '.') count++
            c
        }.toCharArray()
    }


    // m to z
    val moveX = arrayOf(-1, 1, 0, 0)
    val moveY = arrayOf(0, 0, 1, -1)
    val dirPlus = arrayOf(2, 1, 2, 3)

    fun dfs(nowPoint: Point, preDir: DIR = DIR.D, depth: Int = 0) {
        val (x, y) = nowPoint
        val nowValue = arr[x][y]

        when (nowValue) {
            'M' -> {
                for (dir in 0 until 4) {
                    val nx = x + moveX[dir]
                    val ny = y + moveY[dir]

                    if (nx in arr.indices && ny in arr[0].indices) {
                        dfs(Point(nx, ny), DIR.values()[dir], depth + 1)
                    }
                }
            }

            '-', '|' -> {
                val nx = x + moveX[preDir.dirInt]
                val ny = y + moveY[preDir.dirInt]
                dfs(Point(nx, ny), preDir, depth + 1)
            }

            '1', '2', '3', '4' -> {
                val plus = dirPlus[nowValue.digitToInt() - 1]
                val newDir = DIR.values()[(preDir.dirInt + plus) % 4]
                val nx = x + moveX[newDir.dirInt]
                val ny = y + moveY[newDir.dirInt]
                dfs(Point(nx, ny), newDir, depth + 1)
            }

            '+' -> {
                val new = if (preDir.dirInt <= 1) '-'
                else '|'
                arr[x][y] = new

                val nx = x + moveX[preDir.dirInt]
                val ny = y + moveY[preDir.dirInt]
                dfs(Point(nx, ny), preDir, depth + 1)
            }

            //  U(0), D(1), R(2), L(3)
            '.' -> {
                val tmp = preDir.dirInt
                val canGo = arrayListOf<Int>()
                for (dir in 0 until 4) {
                    if (sameDir(tmp,dir)) continue
                    val nx = x + moveX[dir]
                    val ny = y + moveY[dir]
                    if (nx in arr.indices && ny in arr[0].indices && arr[nx][ny] != '.') {
                        val value = arr[nx][ny]
                        if (value == 'Z' && depth == count) {
                            canGo.add(0, dir)
                            break
                        }
                        when (dir) {
                            // up
                            0 -> {
                                if (value == '|' || value == '+' || value == '1' || value == '4') {
                                    canGo.add(dir)
                                }
                            }
                            // down
                            1 -> {
                                if (value == '|' || value == '+' || value == '2' || value == '3') {
                                    canGo.add(dir)
                                }
                            }
                            // right
                            2 -> {
                                if (value == '-' || value == '+' || value == '3' || value == '4') {

                                    canGo.add(dir)
                                }
                            }
                            // left
                            3 -> {
                                if (value == '-' || value == '+' || value == '1' || value == '2') {
                                    canGo.add(dir)
                                }
                            }
                        }
                    }
                }

                if (canGo.isEmpty()) return

                if (canGo.size == 2) {
                    if (sameDir(canGo[0],canGo[1])) return
                }

                if (canGo.size >= 2) {
                    println("${x + 1} ${y + 1} +")
                } else {
                    val canGoDir = DIR.values()[canGo.first()]
                    val pDir = if (preDir == canGoDir) {
                        if (preDir.dirInt <= 1) '|'
                        else {
                            '-'
                        }
                    } else {
                        when (preDir) {
                            DIR.U -> {
                                if (canGoDir == DIR.R) {
                                    '1'
                                } else {
                                    '4'
                                }
                            }
                            DIR.D -> {
                                if (canGoDir == DIR.R) {
                                    '2'
                                } else {
                                    '3'
                                }
                            }
                            DIR.R -> {
                                if (canGoDir == DIR.U) {
                                    '3'
                                } else {
                                    '4'
                                }
                            }
                            DIR.L -> {
                                if (canGoDir == DIR.U) {
                                    '2'
                                } else {
                                    '1'
                                }
                            }
                        }
                    }
                    println("${x + 1} ${y + 1} $pDir")
                    return
                }
            }
        }
    }

    dfs(mPoint)
}

fun sameDir(a: Int, b: Int) : Boolean {
    return if (a == 0 && b == 1) true
    else if (a == 1 && b == 0) true
    else if (a == 2 && b == 3) true
    else a == 3 && b == 2
}

