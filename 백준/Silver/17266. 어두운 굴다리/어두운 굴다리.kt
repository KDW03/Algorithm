fun main() {
    val br = System.`in`.bufferedReader()
    // 굴다리 길이
    val n = br.readLine().toInt()
    // 가로등의 개수
    val m = br.readLine().toInt()

    // 가로등의 위치 x
    val xs = br.readLine().split(" ").map { it.toInt() }

    var start = xs.first()
    var end = n
    var result = n

    while (start <= end) {
        val mid = (start + end) / 2
        if (isAllCovered(n,xs,mid)) {
            result = mid
            end = mid - 1
        }else {
            start = mid + 1
        }
    }

    println(result)
}

fun isAllCovered(n : Int, lamps : List<Int>, height : Int) : Boolean {
    var lastCovered = 0
    for (lamp in lamps) {
        val leftCover = lamp - height
        if (leftCover > lastCovered) return false
        lastCovered = lamp + height
        if (lastCovered >= n) return true
    }
    return lastCovered >= n
}