fun main() {
    val br = System.`in`.bufferedReader()
    val (n, c) = br.readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { br.readLine().toInt() }.sorted()
    var start = 0
    var end = 1000000000

    fun canEstablish(dist: Int): Boolean {
        var installDist = arr.first() + dist
        var count = 1
        for (i in 1 until arr.size) {
            val now = arr[i]
            // 설치할 수 있는 위치 이상이라면 설치
            if (now >= installDist) {
                // 다음 설치 위치
                installDist = now + dist
                count++
            }

            // c개 이상 설치 완료
            if (count >= c) return true
        }
        return false
    }

    while (start <= end) {
        val mid = (start + end) / 2


        if (canEstablish(mid)) {
            // 설치 할 수 있다면
            // 거리를 좀 더 크게
            start = mid + 1
        } else {
            // 해당 거리로 c개 설치할 수 없다면
            // 거리를 좀 더 감소
            end = mid - 1
        }

    }

    println(end)
}

