fun main() {
    val br = System.`in`.bufferedReader()

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.sortedDescending()

    var count = 0

    var first = 0
    var last = arr.size - 1

    while (first < last) {
        val sum = arr[first] + arr[last]
        if (sum > M) {
            first++
        } else if (sum < M) {
            last--
        } else {
            count++
            first++
            last--
        }
    }
    println(count)
}