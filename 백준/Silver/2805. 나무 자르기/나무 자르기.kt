fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toLong() }

    var start = 1L
    var end = arr.max()


    while (start <= end) {
        val middle = (start + end) / 2
        var sum = 0L
        
        for (tree in arr) {
            if (tree > middle) {
                sum += tree - middle
            }
            if (sum >= m) break 
        }

        if (sum >= m) {
            start = middle + 1
        } else {
            end = middle - 1
        }
    }

    println(end)
}