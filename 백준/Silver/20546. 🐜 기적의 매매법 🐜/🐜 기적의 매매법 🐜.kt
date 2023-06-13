fun main() {
    val br = System.`in`.bufferedReader()
    val money = br.readLine().toInt()
    val chart = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val bp = bnp(chart, money)
    val tp = timing(chart, money)

    val answer = if (bp > tp) "BNP" else if (bp < tp) "TIMING" else "SAMESAME"
    println(answer)
}

fun bnp(chart: IntArray, money: Int): Int {
    var nowMoney = money
    var haveCount = 0
    for (i in 0 until chart.size - 1) {
        val nowPrice = chart[i]
        // 살 수 있다면
        if (nowPrice <= nowMoney) {
            haveCount += nowMoney / nowPrice
            nowMoney %= nowPrice
        }
    }
    nowMoney += haveCount * chart.last()
    return nowMoney
}

fun timing(chart: IntArray, money: Int): Int {
    var nowMoney = money
    var haveCount = 0
    // true = 매수 할 때, false 매도 할 때


    for (i in 0 until chart.size - 3) {

        // 감소 하는지 테스트
        if (chart[i] > chart[i + 1] && chart[i + 1] > chart[i + 2] && chart[i + 2] > chart[i + 3]) {
            val nowPrice = chart[i + 3]
            if (nowPrice <= nowMoney) {
                haveCount += nowMoney / nowPrice
                nowMoney %= nowPrice
            }
        }

        // 증가하면
        if (chart[i] < chart[i + 1] && chart[i + 1] < chart[i + 2] && chart[i + 2] < chart[i + 3]) {
            val nowPrice = chart[i + 3]
            if (haveCount > 0) {
                nowMoney += haveCount * nowPrice
                haveCount = 0
            }
        }

    }

    nowMoney += haveCount * chart.last()
    return nowMoney
}
