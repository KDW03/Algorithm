fun main() {
    val br = System.`in`.bufferedReader()
    val start = br.readLine()
    val dest = br.readLine()

    fun dfs(
        a: String, b: String,
    ): Boolean {
        if (a == b) return true

        val first = if (b.contains(a + "B") || b.contains((a + "B").reversed())) dfs((a + "B").reversed(), b) else false
        val second = if (b.contains(a + "A") || b.contains((a + "A").reversed())) dfs(a + "A", b) else false

        return first || second
    }

    val answer = dfs(start, dest)
    println(if (answer) 1 else 0)
}
