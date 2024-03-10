fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { CharArray(n) { ' ' } }
    dfs(arr, n, 0, 0)

    val sb = StringBuilder()
    arr.forEach {
        sb.append(it.joinToString("")).append("\n")
    }
    print(sb.toString())
}

fun dfs(arr: Array<CharArray>, n: Int, x: Int, y: Int) {

    if (n == 1) {
        arr[x][y] = '*'
        return
    }

    val newN = n / 3
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            if (i == 1 && j == 1) continue
            dfs(arr, newN, x + (newN * i), y + (newN * j))
        }
    }
}