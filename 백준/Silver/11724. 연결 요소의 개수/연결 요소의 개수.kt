fun main() {
    val br = System.`in`.bufferedReader()

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(N + 1) { ArrayList<Int>() }
    val visited = BooleanArray(N + 1)

    repeat(M) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        arr[x].add(y)
        arr[y].add(x)
    }


    var count = 0
    for (i in 1..N) {
        if (!visited[i]) {
            dfs(arr, visited, i)
            count++
        }
    }

    println(count)
}

fun dfs(arr: Array<ArrayList<Int>>, visited: BooleanArray, i: Int) {
    visited[i] = true

    for (j in arr[i]){
        if (!visited[j]) {
            dfs(arr,visited,j)
        }
    }
}