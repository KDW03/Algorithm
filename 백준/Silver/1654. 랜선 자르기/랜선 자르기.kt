fun main() {
    val br = System.`in`.bufferedReader()
    val (K, N) = br.readLine().split(" ").map { it.toInt() }

    val arr = ArrayList<Int>()
    var max = Int.MIN_VALUE
    repeat(K) {
        val num = br.readLine().toInt()
        arr.add(num)
        max = maxOf(max, num)
    }

    var start = 1L
    var end = max.toLong()

    while (start <= end) {
        val medium = (start + end) / 2
        val sum = arr.sumOf { it / medium }

        if (sum >= N) {
            start = medium + 1
        } else {
            end = medium - 1
        }
    }

    println(start - 1)
}