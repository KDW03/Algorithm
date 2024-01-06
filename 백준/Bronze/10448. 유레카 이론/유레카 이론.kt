fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    val triangleNumbers = ArrayList<Int>()
    var num = 1
    var triNum = 1
    while (triNum <= 1000) {
        triangleNumbers.add(triNum)
        num++
        triNum = num * (num + 1) / 2
    }

    val b = BooleanArray(1001)
    for (i in triangleNumbers) {
        for (j in triangleNumbers) {
            for (k in triangleNumbers) {
                val sum = i + j + k
                if (sum <= 1000) b[sum] = true
            }
        }
    }

    repeat(t) {
        val num = br.readLine().toInt()
        println(if (b[num]) 1 else 0)
    }
}