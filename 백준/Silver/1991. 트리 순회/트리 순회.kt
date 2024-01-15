data class Node(val num: Int, var child: Pair<Int, Int> = Pair(0, 0))

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val tree = Array(n + 1) { Node(it) }

    repeat(n) {
        val (parent, oneC, twoC) = br.readLine().split(" ").map {
            val t = it[0]
            if (t == '.') {
                0
            } else {
                t - 'A' + 1
            }
        }
        tree[parent].child = Pair(oneC, twoC)
    }
    val sb = StringBuilder()

    // 전위
    fun dfs(start: Int) {
        val (left, right) = tree[start].child
        sb.append('A' + start - 1)
        if (left != 0) dfs(left)
        if (right != 0) dfs(right)
    }

    // 중위
    fun dfs2(start: Int) {
        val (left, right) = tree[start].child
        if (left != 0) dfs2(left)
        sb.append('A' + start - 1)
        if (right != 0) dfs2(right)
    }

    // 후위
    fun dfs3(start: Int) {
        val (left, right) = tree[start].child
        if (left != 0) dfs3(left)
        if (right != 0) dfs3(right)
        sb.append('A' + start - 1)
    }

    dfs(1)
    sb.append("\n")
    dfs2(1)
    sb.append("\n")
    dfs3(1)

    print(sb.toString())
}