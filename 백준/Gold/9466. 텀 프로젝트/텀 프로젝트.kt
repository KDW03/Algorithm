import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val choices = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val visited = BooleanArray(n + 1)
        val finished = BooleanArray(n + 1)
        var teamCount = 0

        fun dfs(v: Int) {
            // 방문 처리
            visited[v] = true
            // next
            val next = choices[v - 1]
            // next가 방문하지 않았다면 계속 dfs 진행
            if (!visited[next]) {
                dfs(next)
            } else if (!finished[next]) {
                // 방문했는데 끝나지 않았다면
                var temp = next
                teamCount++
                while (temp != v) {
                    teamCount++
                    temp = choices[temp - 1]
                }
            }
            finished[v] = true
        }

        for (i in 1..n) if (!visited[i]) dfs(i)


        println(n - teamCount)
    }
}
