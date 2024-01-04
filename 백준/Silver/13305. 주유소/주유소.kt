fun main() {
    val n = readLine()!!.toInt() // 도시의 개수
    val distances = readLine()!!.split(" ").map { it.toLong() } // 각 도시간 거리
    val prices = readLine()!!.split(" ").map { it.toLong() } // 각 도시의 기름 가격

    var totalCost = 0L
    var minPrice = prices[0]

    for (i in 0 until n - 1) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]
        }
        totalCost += minPrice * distances[i]
    }

    println(totalCost)
}
