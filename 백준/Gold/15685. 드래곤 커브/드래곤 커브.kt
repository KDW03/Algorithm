val moveX = arrayOf(1, 0, -1, 0)
val moveY = arrayOf(0, -1, 0, 1)

fun move(x: Int, y: Int, direction: Int, visited: Array<BooleanArray>): Pair<Int, Int> {

    val nx = x + moveX[direction]
    val ny = y + moveY[direction]

    if (ny in visited.indices && nx in visited[0].indices) {
        visited[ny][nx] = true
        return Pair(nx, ny)
    }

    return Pair(-1, -1)
}

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val visited = Array(101) { BooleanArray(101) }

    repeat(t) {
        val (x, y, d, g) = br.readLine().split(" ").map { it.toInt() }
        visited[y][x] = true
        val directions = ArrayList<Int>()
        directions.add(d)

        var (newX, newY) = move(x, y, d, visited)

        for (i in 0 until g) {
            val tempDirections = directions.map { (it + 1) % 4 }.reversed()
            tempDirections.forEach {
                val result = move(newX, newY, it, visited)
                newX = result.first
                newY = result.second
            }
            directions.addAll(tempDirections)
        }
    }

    var count = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1][j + 1]) {
                count++
            }
        }
    }

    println(count)
}