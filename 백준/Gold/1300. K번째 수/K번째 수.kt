fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toLong()
    val k = br.readLine().toLong()

    var start = 1L
    var end : Long = n * n
    var ans = 0L
    while (start <= end) {

        val mid = (start + end) / 2
        var count = 0L
        for (i in 1..n) {
            // i * j <= mid
            count += minOf(n, mid / i)
        }
        if (count < k) {
            start = mid + 1
        }else {
            end = mid - 1
            ans = mid
        }
    }
    println(ans)
}
