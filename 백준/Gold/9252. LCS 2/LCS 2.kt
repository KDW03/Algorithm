fun main() {
    val br = System.`in`.bufferedReader()

    val a = br.readLine()
    val b = br.readLine()
    val alen = a.length
    val blen = b.length
    val arr = Array(alen) { IntArray(blen) }
    for (x in arr.indices) {
        val aChar = a[x]
        for (y in arr[0].indices) {
            val bChar = b[y]
            if (aChar == bChar) {
                val preValue = if (x - 1 >= 0 && y - 1 >= 0) {
                    arr[x - 1][y - 1]
                } else {
                    0
                }
                arr[x][y] = preValue + 1
            } else {
                val j = if (x - 1 >= 0) arr[x - 1][y] else 0
                val k = if (y - 1 >= 0) arr[x][y - 1] else 0
                arr[x][y] = maxOf(j, k)
            }
        }
    }

    var startX = alen - 1
    var startY = blen - 1
    var startValue = arr[alen - 1][blen - 1]
    println(startValue)
    if (startValue == 0) return
    val sb = StringBuilder()
    while (true) {
        val j = if (startX - 1 >= 0) arr[startX - 1][startY] else -1
        val k = if (startY - 1 >= 0) arr[startX][startY - 1] else -1
        if (j == startValue) {
            startX--
        } else if (k == startValue) {
            startY--
        } else {
            sb.append(b[startY])
            if (startX - 1 >= 0 && startY - 1 >= 0) {
                startX--
                startY--
                startValue = arr[startX][startY]
                if (startValue == 0) break
            } else {
                break
            }

        }
    }

    println(sb.reversed().toString())
}
