import java.util.*


data class Home(var idx: Int, var value: Int)

class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer = 0L
        val homeD = Stack<Home>()
        val homeP = Stack<Home>()

        (deliveries.indices).forEach {
            if (deliveries[it] != 0) homeD.push(Home(it + 1, deliveries[it]))
            if (pickups[it] != 0) homeP.push(Home(it + 1, pickups[it]))
        }


        while (true) {

            if (homeD.size + homeP.size == 0) break

            var max = 0
            var dSum = cap
            var pSum = cap

            while (homeD.isNotEmpty()) {
                val dHome = homeD.pop()
                val r = minOf(dHome.value, dSum)
                dHome.value -= r
                dSum -= r
                if (dHome.value != 0) {
                    homeD.push(dHome)
                }
                max = maxOf(dHome.idx, max)
                if (dSum == 0) break
            }

            while (homeP.isNotEmpty()) {
                val pHome = homeP.pop()
                val r = minOf(pHome.value, pSum)
                pHome.value -= r
                pSum -= r
                if (pHome.value != 0) {
                    homeP.push(pHome)
                }
                max = maxOf(pHome.idx, max)
                if (pSum == 0) break
            }

            answer += max

        }

        return answer * 2
    }
}
