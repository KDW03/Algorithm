data class Cluster(val parts: ArrayList<Part> = arrayListOf())
data class Part(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    // 동굴의 크기
    val (r, c) = br.readLine().split(" ").map { it.toInt() }

    // 동굴
    val board = Array(r) { br.readLine().toCharArray() }

    // 막대를 던진 횟수
    val n = br.readLine().toInt()
    // 막대를 던진 높이들
    val hs = br.readLine().split(" ").map { it.toInt() }
    val moveX = arrayOf(0, 0, -1, 1)
    val moveY = arrayOf(1, -1, 0, 0)

    // height 만큼 cluster 이동
    fun moveCluster(cluster: Cluster, height: Int) {
        for ((x, y) in cluster.parts.sortedByDescending { it.x }) {
            board[x][y] = '.'
            board[x + height][y] = 'x'
        }
    }

    // 떨어질 수 있는 클러스터 height구하기
    fun downCluster(cluster: Cluster) {

        var height = 0
        // 한칸 떨어질 수 있다면

        // 초기포지션
        val firstPosition = Array(r) { BooleanArray(c) }

        cluster.parts.forEach {
            firstPosition[it.x][it.y] = true
        }

        while (true) {
            height++
            val result = cluster.parts.all {
                val x = it.x + height
                val y = it.y
                x in board.indices && (board[x][y] == '.' || firstPosition[x][y])
            }
            if (!result) break
        }
        height--
        // 한칸이라도 떨어질 수 있다면
        if (height >= 1) {
            moveCluster(cluster, height)
        }
    }

    // 떨어지는 클러스터 찾기
    fun findDownCluster(
        visited: Array<BooleanArray>,
        startX: Int,
        startY: Int,
    ): Pair<Boolean, Cluster> {
        var flag = true
        val cluster = Cluster()

        fun dfs(visited: Array<BooleanArray>, x: Int, y: Int) {
            visited[x][y] = true
            cluster.parts.add(Part(x, y))
            // 바닥에 닿아있다면 안 떨어짐
            if (x == r - 1) flag = false
            for (i in 0 until 4) {
                val nx = x + moveX[i]
                val ny = y + moveY[i]
                if (nx in board.indices && ny in board[0].indices && !visited[nx][ny] && board[nx][ny] == 'x') {
                    dfs(visited, nx, ny)
                }
            }
        }

        dfs(visited, startX, startY)
        return Pair(flag, cluster)
    }

    // 해당 옆에서 던지는 방향에서 가장 근접한 x 찾고 부수기
    for (i in hs.indices) {
        // 왼쪽에서 오른쪽
        val height = r - hs[i]
        val idx = if (i % 2 == 0) {
            board[height].indexOfFirst { it == 'x' }
        } else {
            // 오른쪽에서 왼쪽
            board[height].indexOfLast { it == 'x' }
        }

        // 미네랄이 창에 의해 안깨지면 continue
        if (idx != -1) board[height][idx] = '.'
        else continue

        // 깨졌다면 그 주위 탐색으로 down 클러스터 찾기
        val visited = Array(r) { BooleanArray(c) }
        var downCluster: Cluster? = null
        for (j in 0 until 4) {
            val nx = height + moveX[j]
            val ny = idx + moveY[j]
            if (nx in board.indices && ny in board[0].indices && !visited[nx][ny] && board[nx][ny] == 'x') {
                val result = findDownCluster(visited, nx, ny)
                if (result.first) {
                    downCluster = result.second
                }
            }
        }

        // 떨어지는 클러스터가 있다
        if (downCluster != null) downCluster(downCluster)
    }


    val sb = StringBuilder()
    board.forEach {
        sb.append(it.joinToString("")).append("\n")
    }
    print(sb.toString().trimEnd())
}


