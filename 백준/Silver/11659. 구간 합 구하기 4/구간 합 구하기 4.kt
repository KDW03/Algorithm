fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    arr.add(0,0)

    for (i in 1 until arr.size) {
        arr[i] += arr[i - 1]
    }

    val sb = StringBuilder()

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        sb.append(arr[b] - arr[a - 1]).append("\n")
    }

    println(sb.toString())
}