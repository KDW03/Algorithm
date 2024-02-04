fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val output = IntArray(m)
    val sb = StringBuilder()
    dfs(nums, output, 0, 0, n, m,sb)
    println(sb.toString())
}

fun dfs(nums: IntArray, output: IntArray, depth: Int, start: Int, n: Int, m: Int, sb: StringBuilder) {
    if (depth == m) {
        sb.append(output.joinToString(" ")).append("\n")
        return
    }

    for (i in 0 until n) {
        output[depth] = nums[i]
        dfs(nums, output, depth + 1, i, n, m, sb)
    }
}
