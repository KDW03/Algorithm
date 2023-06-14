lateinit var graph: Array<IntArray>
// 1 익은 토마토
// 0 익지않은 토마토
// -1 토마토 x
var M = 0
var N = 0
fun main() {
    val br = System.`in`.bufferedReader()
    //N  상자의 세로
    //M  상자의 가로
    br.readLine().split(" ").map { it.toInt() }.let {
        M = it[0]
        N = it[1]
    }
    graph = Array(N) { IntArray(M) }
    val tmp = arrayListOf<RipeTomato>()
    repeat(N) { x ->
        val input = br.readLine().split(" ").map { it.toInt() }
        for (y in input.indices) {
            val status = input[y]
            graph[x][y] = status
            if (status == 1) tmp.add(RipeTomato(x, y))
        }
    }
    var day = 0
    val tomatoList = RipeTomas(tmp)
    while (true) {
        // 오늘 익은 토마토가 없다 --> 다 익었거나 (끝내고 day print), 모두 익지 못하는 상황인거나(끝내고 print(-1))
        if (tomatoList.checkCount() == 0) {
            // 익지 않은게
            var count = 0
            graph.forEach {
                count += it.count { it == 0 }
            }
            // 익지 않은게 있다면
            if (count != 0) {
                println(-1)
            } else {
                println(day)
            }
            return
        }
        tomatoList.nextDay()
        day++
    }

}

val moveX = arrayOf(0, 0, 1, -1)
val moveY = arrayOf(1, -1, 0, 0)

fun canMove(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until M && graph[x][y] == 0

data class RipeTomas(var tomatoList: ArrayList<RipeTomato> = arrayListOf()) {

    init {
        nextDay()
    }

    fun nextDay() {
        var tmp = arrayListOf<RipeTomato>()
        for (tomato in tomatoList) {
            for (i in 0 until 4) {
                val newX = tomato.x + moveX[i]
                val newY = tomato.y + moveY[i]
                if (canMove(newX, newY)) {
                    graph[newX][newY] = 1
                    tmp.add(RipeTomato(newX, newY))
                }
            }
        }
        tomatoList = tmp
    }

    fun checkCount() = tomatoList.size
}

data class RipeTomato(val x: Int, val y: Int)