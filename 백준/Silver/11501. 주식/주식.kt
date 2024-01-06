fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val prices = br.readLine().split(" ").map { it.toLong() }

        var maxPrice = 0L
        var profit = 0L

        for (i in n - 1 downTo 0) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i]
            } else {
                profit += maxPrice - prices[i]
            }
        }

        println(profit)
    }
}
