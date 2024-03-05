fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine().toCharArray()

    val allBCount = str.count { it == 'b' }
    val cycleStr = str + str
    val windowSize = allBCount
    var start = 0
    var end = 0
    var nowBCount = 0
    var maxBCount = 0
    while (start < str.size) {

        if (end < windowSize) {
            val now = cycleStr[end]
            if (now == 'b') nowBCount++
            maxBCount = maxOf(maxBCount, nowBCount)
            end++
            continue
        }

        val remove = cycleStr[start++]
        val add = cycleStr[end++]

        if (remove == 'b') nowBCount--
        if (add == 'b') nowBCount++
        maxBCount = maxOf(maxBCount, nowBCount)
    }

    println(allBCount - maxBCount)
}