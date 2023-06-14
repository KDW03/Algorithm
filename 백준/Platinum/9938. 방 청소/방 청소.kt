import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, L) = br.readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    val nodeArr = IntArray(L + 1)
    val visited = BooleanArray(L + 1)
    for (i in 1..L) {
        nodeArr[i] = i
    }

    repeat(N) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val answer = if (!visited[a]) {
            visited[a] = true
            union(a, b, nodeArr)
            "LADICA"
        } else if (!visited[b]) {
            visited[b] = true
            union(b, a, nodeArr)
            "LADICA"
        } else if (!visited[find(nodeArr[a], nodeArr)]) {
            visited[find(nodeArr[a], nodeArr)] = true
            union(a, b, nodeArr)
            "LADICA"
        } else if (!visited[find(nodeArr[b], nodeArr)]) {
            visited[find(nodeArr[b], nodeArr)] = true
            union(b, a, nodeArr)
            "LADICA"
        } else {
            "SMECE"
        }
        sb.append(answer).append("\n")
    }
    print(sb.toString())
}

fun find(x: Int, node: IntArray): Int {
    if (x == node[x]) return x
    node[x] = find(node[x], node)
    return node[x]
}

fun union(x: Int, y: Int, node: IntArray) {
    val xParent = find(x, node)
    val yParent = find(y, node)
    node[xParent] = yParent
}
