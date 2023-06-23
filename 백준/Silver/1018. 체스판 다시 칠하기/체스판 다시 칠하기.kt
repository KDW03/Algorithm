fun main() {

    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { br.readLine().toCharArray() }
    var minCount = Int.MAX_VALUE

    outer@ for (x in 0 until n) {
        for (y in 0 until m) {
            if (!checkIsAble(n, m, x, y)) continue@outer
            minCount = minOf(minCount, getCount(x, y, arr))
        }
    }

    println(minCount)

}

fun getCount(x: Int, y: Int, arr: Array<CharArray>): Int {
    val tmp = arr.slice(x..x + 7).map { it.slice(y..y + 7) }
    val new = tmp.joinToString("") { it.joinToString("") }

    val first1 = new.first()
    val first2 = if (first1 == 'B') 'W' else 'B'
    var count1 = 0
    var count2 = 0

    for (i in new.indices) {
        if ((i + i / 8) % 2 == 0) {
            if (new[i] != first1) count1++
        } else {
            if (new[i] == first1) count1++
        }
    }

    for (i in new.indices) {
        // == 짝수라면
        if ((i + i / 8) % 2 == 0) {
            if (new[i] != first2) count2++
        } else {
            if (new[i] == first2) count2++
        }
    }

    return minOf(count1, count2)
}


fun checkIsAble(n: Int, m: Int, x: Int, y: Int) = x + 8 <= n && y + 8 <= m

