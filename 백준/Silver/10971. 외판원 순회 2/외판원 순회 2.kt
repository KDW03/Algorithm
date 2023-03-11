var count = Int.MAX_VALUE
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { IntArray(n) }
    for (i in arr.indices) arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in 0 until n) {
        val visited = BooleanArray(n) { false }
        search(i, arr, i, visited, 0)
    }
    count = if (count == Int.MAX_VALUE) 0 else count
    println(count)
}
fun search(start: Int, arr: Array<IntArray>, now: Int, visited: BooleanArray, sum: Int) {
    visited[now] = true

    if (visited.count { it == true } == arr.size) {
        if (arr[now][start] != 0) count = minOf(count, sum + arr[now][start])
        return
    }


    for (i in arr[now].indices) {
        val cost = arr[now][i]
        if (!visited[i] && cost != 0) {
            search(start, arr, i, visited, sum + cost)
            visited[i] = false
        }
    }
}


