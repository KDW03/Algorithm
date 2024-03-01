fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val nums = n.toString().toCharArray().map { it.digitToInt() }.toIntArray()
    val visited = Array(11) { BooleanArray(1000001) }
    val answer = dfs(nums, k, visited)
    println(if (answer == Int.MIN_VALUE) -1 else answer)
}

fun dfs(nums: IntArray, k: Int, visited: Array<BooleanArray>, cost: Int = 0): Int {
    var max = Int.MIN_VALUE
    val size = nums.size
    // i 와 j 를 바꾼다.
    val now = nums.joinToString("").toInt()
    if (visited[cost][now]) return max
    visited[cost][now] = true
    if (cost == k) return nums.joinToString("").toInt()

    for (i in 0 until size - 1) {
        for (j in i + 1 until size) {
            if (i == 0 && nums[j] == 0) continue
            swap(nums, i, j)
            max = maxOf(dfs(nums, k, visited, cost + 1), max)
            swap(nums, i, j)
        }
    }
    return max
}


fun swap(nums: IntArray, i: Int, j: Int) {
    val tmp = nums[i]
    nums[i] = nums[j]
    nums[j] = tmp
}