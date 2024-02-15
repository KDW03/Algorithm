fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { br.readLine().toCharArray() }
    val sb = StringBuilder()

    var ans = 0
    // 각 행마다
    for (i in 0 until n) {
        var count = 0
        for (value in arr[i]) {
            if (value == 'X') {
                if (count >= 2) ans++
                count = 0
            } else {
                count++
            }
        }
        if (count >= 2) ans++
    }
    sb.append(ans).append(" ")
    ans = 0
    // 각 열마다
    for (y in 0 until n) {
        var count = 0
        for (x in 0 until n) {
            val value = arr[x][y]
            if (value == 'X') {
                if (count >= 2) ans++
                count = 0
            } else {
                count++
            }
        }
        if (count >= 2) ans++
    }
    sb.append(ans)
    println(sb.toString())
}