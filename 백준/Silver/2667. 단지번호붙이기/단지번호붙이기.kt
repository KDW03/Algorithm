lateinit var visited: Array<BooleanArray>
lateinit var answerList: ArrayList<Int>
var n = 0

fun main() {
    val br = System.`in`.bufferedReader()
    n = br.readLine().toInt()
    visited = Array(n) { BooleanArray(n) }
    answerList = arrayListOf()
    repeat(n) {
        val input = br.readLine()
        for (i in input.indices) {
            visited[it][i] = input[i] != '1'
        }
    }
    for (x in 0 until n) {
        for (y in 0 until n) {
            if (!visited[x][y]) {
                answerList.add(dfs(x, y))
            }
        }
    }
    println(answerList.size)
    answerList.sorted().forEach {
        println(it)
    }
}

val moveX = arrayOf(1, -1, 0, 0)
val moveY = arrayOf(0, 0, 1, -1)

fun dfs(x: Int, y: Int): Int {
    var count = 1
    visited[x][y] = true
    for (i in 0 until 4) {
        val newX = x + moveX[i]
        val newY = y + moveY[i]
        if (canMove(newX, newY) && !visited[newX][newY]) {
            count += dfs(newX, newY)
        }
    }
    return count
}

fun canMove(x: Int, y: Int): Boolean {
    return x in 0 until n && y in 0 until n
}