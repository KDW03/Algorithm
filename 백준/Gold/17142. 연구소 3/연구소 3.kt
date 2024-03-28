import java.util.*
import kotlin.collections.ArrayList

data class Point(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val candi = ArrayList<Point>()

    val arr = Array(n) { x ->
        br.readLine().split(" ").mapIndexed { y, it ->
            val num = it.toInt()
            if (num == 2) candi.add(Point(x, y))
            num
        }
    }

    var min = Int.MAX_VALUE

    val moveX = arrayOf(-1, 1, 0, 0)
    val moveY = arrayOf(0, 0, -1, 1)
    val range = 0 until n

    // starts에서 bfs진행하면서 최소 map 갱신
    fun bfs(starts: IntArray) {
        val distMap = Array(n) { IntArray(n) { Int.MAX_VALUE } }

        val q = PriorityQueue<Pair<Point, Int>> { o1, o2 ->
            o1.second - o2.second
        }

        starts.forEach {
            val (x, y) = candi[it]
            q.add(Pair(candi[it], 0))
            distMap[x][y] = 0
        }

        while (q.isNotEmpty()) {
            val (p, cost) = q.poll()
            val (x, y) = p

            for (i in 0 until 4) {
                val nx = x + moveX[i]
                val ny = y + moveY[i]
                // 범위내, 벽이 아니고, newCost가 더 작다면
                val newCost = cost + 1
                if (nx in range && ny in range && arr[nx][ny] != 1 && distMap[nx][ny] > newCost) {
                    distMap[nx][ny] = newCost
                    q.add(Pair(Point(nx, ny), newCost))
                }
            }

        }

        var max = 0
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (arr[x][y] == 0) {
                    max = maxOf(max,distMap[x][y])
                }
            }
        }

        min = minOf(min,max)
    }


    fun combi(i: Int = 0, now: IntArray = intArrayOf()) {
        // m이면 bfs 시작
        if (now.size == m) {
            bfs(now)
            return
        }

        for (k in i until candi.size) combi(k + 1, now + k)
    }

    // 후보중 m개 뽑기
    combi()

    if (min == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(min)
    }
}