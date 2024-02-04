fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    dfs(n, m, nums, 0, intArrayOf())
}

fun dfs(n: Int, m: Int, nums: IntArray, i: Int, arr: IntArray) {

    if (arr.size == m) {
        println(arr.joinToString(" "))
        return
    }

    for (index in i until nums.size) dfs(n, m, nums, index + 1, arr + nums[index])
}