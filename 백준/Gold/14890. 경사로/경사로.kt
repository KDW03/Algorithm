import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    // 길에 속한 모든 칸의 높이가 모두 같다
    // 경사로를 놓아서 지나갈 수 있는 길
    // 경사로는 높이가 항상 1이며, 길이는 L
    val (n, L) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    //val visited = Array(n) { BooleanArray(n) }
    var totalCount = 0
    // 행 길 부터 탐색

    outer@ for (x in 0 until n) {
        var pre: Int? = null
        var sequenceCount = 1
        var y = 0
        while (y in 0 until n) {
            val now = arr[x][y]
            // if pre null -> pre 갱신
            if (pre == null) {
                pre = now
                sequenceCount = 1
                y++
                continue
            }

            // 높이가 같을 때
            if (now == pre) {
                sequenceCount++
                y++
                continue
            }

            // 높이차가 1 이상이면 패스
            if (abs(now - pre) > 1) continue@outer

            // 높이가 높아졌을 때
            if (now > pre) {
                // 경사로 길이보다 이전 연속이 길다면
                if (sequenceCount >= L) {
                    pre = null
                    continue
                } else continue@outer
            } else {  // 높이가 낮아졌을 때
                var frontSequence = 1
                for (fy in 1 until L) {
                    if (y + fy !in 0 until n) continue@outer
                    if (arr[x][y + fy] == now) frontSequence++ else continue@outer
                }
                // 만약 L개만큼 연속된다면
                if (frontSequence == L) {
                    pre = now
                    sequenceCount = 0
                    y += frontSequence
                    continue
                } else {
                    continue@outer
                }
            }
        }
        totalCount++
    }


    outer@ for (y in 0 until n) {
        var pre: Int? = null
        var sequenceCount = 1
        var x = 0
        while (x in 0 until n) {
            val now = arr[x][y]
            // if pre null -> pre 갱신
            if (pre == null) {
                pre = now
                sequenceCount = 1
                x++
                continue
            }

            // 높이가 같을 때
            if (now == pre) {
                sequenceCount++
                x++
                continue
            }

            // 높이차가 1 이상이면 패스
            if (abs(now - pre) > 1) continue@outer

            // 높이가 높아졌을 때
            if (now > pre) {
                // 경사로 길이보다 이전 연속이 길다면
                if (sequenceCount >= L) {
                    pre = null
                    continue
                } else continue@outer
            } else {  // 높이가 낮아졌을 때
                var frontSequence = 1
                for (fx in 1 until L) {
                    if (x + fx !in 0 until n) continue@outer
                    if (arr[x + fx][y] == now) frontSequence++ else continue@outer
                }
                // 만약 L개만큼 연속된다면
                if (frontSequence == L) {
                    pre = now
                    sequenceCount = 0
                    x += frontSequence
                    continue
                } else {
                    continue@outer
                }
            }
        }
        totalCount++
    }
    println(totalCount)
}