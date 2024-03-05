fun main() {
    val br = System.`in`.bufferedReader()

    // 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }

    val arr = ArrayList<Int>()

    repeat(n) {
        val num = br.readLine().toInt()
        arr.add(num)
    }

    val cycleArr = arr + arr

    val nowHave = hashMapOf<Int, Int>()
    nowHave[c] = 1

    for (i in 0 until k) {
        val now = cycleArr[i]
        nowHave[now] = nowHave.getOrDefault(now, 0) + 1
    }

    var startIdx = 0
    var endIdx = k
    var answer = nowHave.keys.size

    while(startIdx in arr.indices) {
        val remove = cycleArr[startIdx++]
        val add = cycleArr[endIdx++]

        nowHave[remove] = nowHave[remove]!! - 1
        if (nowHave[remove]!! <= 0) {
            nowHave.remove(remove)
        }

        nowHave[add] = nowHave.getOrDefault(add,0) + 1
        answer = maxOf(answer, nowHave.keys.size)
    }

    println(answer)
}