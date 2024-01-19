import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    if (n >= m) {
        println(n - m)
        return
    }
    val ans = IntArray(2 * 100000 + 1) { Int.MAX_VALUE }
    ans[n] = 0
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(n, 0))

    while (q.isNotEmpty()) {
        val (p, cost) = q.poll()
        if (cost >= ans[m]) {
            continue
        }
        if (p == m) {
            ans[m] = cost
            continue
        }
        for (i in 0 until 3) {
            var newP = 0
            var newCost = cost
            when (i) {
                0 -> if (p != 0) {
                    newP = p * 2
                }
                1 -> {
                    newP = p + 1
                    newCost = cost + 1
                }
                2 -> {
                    newP = p - 1
                    newCost = cost + 1
                }
            }
            if (newP in ans.indices && newCost < ans[newP]) {
                ans[newP] = newCost
                q.add(Pair(newP, newCost))
            }
        }
    }
    println(ans[m])
}
