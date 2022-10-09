import java.util.LinkedList
import java.util.Queue

fun main() {

    data class Swan(val x: Int, val y: Int) {
        fun getLocation() = Pair(x, y)
    }

    val moveX = arrayOf(-1, 1, 0, 0)
    val moveY = arrayOf(0, 0, -1, 1)
    val swanMemory: Queue<Pair<Int, Int>> = LinkedList()
    val findSwanQ: Queue<Pair<Int, Int>> = LinkedList()
    val iceQ: Queue<Pair<Int, Int>> = LinkedList()
    val findIceQ: Queue<Pair<Int, Int>> = LinkedList()
    var count = 0
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(' ').map { it.toInt() }
    val visited = Array(r) { BooleanArray(c) }
    val visited2 = Array(r) { BooleanArray(c) }
    val arr = Array(r) { CharArray(c) }
    val swanList = ArrayList<Swan>()

    // X == 0 ;  . == 1  ; L == 2
    // 배열 초기화

    for (i in 0 until r) {
        val input = br.readLine()
        for (j in 0 until c){
            arr[i][j] = input[j]
            if (input[j] == 'L') swanList.add(Swan(i,j))
        }
    }

    // 다음날에 녹일 얼음 준비 초기 작업
    for (i in 0 until r) {
        for (j in 0 until c) {
            // 물이면 검사
            if (!(arr[i][j] == 'X')) {
                for (k in 0 until 4) {
                    val dx = i +  moveX[k]
                    val dy = j + moveY[k]

                    if (dx < 0 || dy < 0 || dx >= r || dy >= c || visited2[dx][dy] || arr[dx][dy] != 'X') continue
                    // 다음날에 녹일 얼음 준비
                    visited2[dx][dy] = true
                    iceQ.add(Pair(dx, dy))
                }
            }
        }
    }

    swanMemory.add(swanList[0].getLocation())

    while (true) {
        // bfs 백조 찾기
        // 백조 탐색 시작할 위치 q에 담고
        findSwanQ.addAll(swanMemory)
        swanMemory.clear()

        while (findSwanQ.isNotEmpty()) {
            val tmp = findSwanQ.poll()
            for (i in 0 until 4) {
                // 위치 이동
                val dx = tmp.first + moveX[i]
                val dy = tmp.second + moveY[i]

                // 범위가 아니거나 이미 방문한 곳이라면 pass
                if (dx < 0 || dy < 0 || dx >= r || dy >= c || visited[dx][dy]) continue

                visited[dx][dy] = true
                if (arr[dx][dy] == 'X') {                 // 얼음 이라면 다음날 탐색할 곳인 swanQ에 넣고
                    swanMemory.add(Pair(dx, dy))
                }
                if (arr[dx][dy] == '.') {                 // 갈수 있는 곳이라면 현재 탐색 할 곳인 Q에 넣고
                    findSwanQ.add(Pair(dx, dy))
                }
            }
        }

        // 백조가 만났으면 return
        swanList[1].getLocation().let {
            if (visited[it.first][it.second]) {
                print(count)
                return
            }
        }

        count++
        // 백조 못 만났으면 물 없애기
        findIceQ.addAll(iceQ)
        iceQ.clear()
        while (findIceQ.isNotEmpty()) {
            val tmp = findIceQ.poll()
            arr[tmp.first][tmp.second] = '.'
            for (i in 0 until 4) {
                // 위치 이동
                val dx = tmp.first + moveX[i]
                val dy = tmp.second + moveY[i]

                // 범위가 아니거나 이미 방문한 곳이라면 pass
                if (dx < 0 || dy < 0 || dx >= r || dy >= c || visited2[dx][dy]) continue

                visited2[dx][dy] = true

                if (arr[dx][dy] == 'X') { //빙판이니간 녹이자
                    iceQ.add(Pair(dx, dy))
                } else{ //물이거나 백조면 탐색하게 q에 넣어주자
                    findIceQ.add(Pair(dx, dy))
                }
            }
        }
    }
}


