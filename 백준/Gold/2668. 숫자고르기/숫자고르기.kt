import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val toArr =  intArrayOf(0) + IntArray(n) { br.readLine().toInt() }
    val visited =  BooleanArray(n + 1)
    val finished = BooleanArray(n + 1)
    var answer = ArrayList<Int>()

    fun dfs(i: Int) {

        visited[i] = true
        val to = toArr[i]

        // next 방문하지 않았다면
        if (!visited[to]) {
            dfs(to)
            // next 방문은 했는데 끝나지 않았다면
        } else if (!finished[to]) {
            var v = to
            answer.add(v)
            // 사이클 돌기
            while (i != v) {
                v = toArr[v]
                answer.add(v)
            }
        }

        // to finish
        finished[i] = true
    }

    for (i in toArr.indices) {
        if (i == 0) continue
        if (!visited[i]) dfs(i)
    }

    val sb = StringBuilder()
    sb.append(answer.size).append("\n")
    for (num in answer.sorted()) {
        sb.append(num).append("\n")
    }

    println(sb.toString())
}