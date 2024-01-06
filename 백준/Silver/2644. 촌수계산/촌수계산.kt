import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()

    // 전체 사람의 수
    val n = br.readLine().toInt()
    val map: MutableMap<Int, ArrayList<Int>> = mutableMapOf()
    val visited = BooleanArray(n + 1)
    // 관계 계산해야할 두 사람 번호
    val (a, b) = br.readLine().split(" ").map { it.toInt() }

    // 관계의 개수 m
    val m = br.readLine().toInt()


    //부모 자식 관계
    // x는 부모 y는 자식
    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        if (map[x] == null) map[x] = ArrayList()
        if (map[y] == null) map[y] = ArrayList()
        map[x]?.add(y)
        map[y]?.add(x)
    }

    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(a, 0))

    while (q.isNotEmpty()) {
        val t = q.poll()
        if (t.first == b) {
            println(t.second)
            return
        }
        visited[t.first] = true
        map[t.first]?.forEach {
            if (!visited[it]) {
                q.add(Pair(it,t.second + 1))
            }
        }
    }

    println(-1)
}