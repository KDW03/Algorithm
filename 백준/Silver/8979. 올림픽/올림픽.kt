fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { "" }
    repeat(n) {
        val tmp = br.readLine().split(" ").joinToString("")
        val idx = tmp.first()
        val str = tmp.drop(1)
        arr[idx.digitToInt() - 1] = str
    }
    val find = arr[k - 1]
    println(arr.sortedDescending().indexOfFirst { it == find } + 1)
}