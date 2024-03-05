fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = arrayListOf<Int>()
    repeat(n) {
        arr.addAll(br.readLine().split(" ").map { it.toInt() })
    }

    println(arr.sortedDescending()[n - 1])
}