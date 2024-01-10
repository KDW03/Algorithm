import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val q : Queue<Pair<Int,String>> = LinkedList()
        val visited = BooleanArray(10001)

        q.add(Pair(a,""))
        visited[a] = true

        while (q.isNotEmpty()) {
            val (p,ans) = q.poll()

            if (p == b) {
                sb.append(ans).append("\n")
                break
            }

            val D = (2 * p) % 10000
            val S = if (p == 0) 9999 else p - 1
            val L = (p % 1000) * 10 + p / 1000
            val R = (p % 10) * 1000 + p / 10

            if (!visited[D]) {
                q.add(Pair(D,ans + "D"))
                visited[D] = true
            }

            if (!visited[S]) {
                q.add(Pair(S,ans + "S"))
                visited[S] = true
            }

            if (!visited[L]) {
                q.add(Pair(L,ans + "L"))
                visited[L] = true
            }

            if (!visited[R]) {
                q.add(Pair(R,ans + "R"))
                visited[R] = true
            }
        }
    }

    print(sb.toString())
}
