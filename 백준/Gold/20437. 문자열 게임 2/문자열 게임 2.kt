import java.io.*

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val w = br.readLine()
        val k = br.readLine().toInt()
        val positions = Array(26) { mutableListOf<Int>() }

        // 각 문자의 등장 위치를 저장
        w.forEachIndexed { index, c ->
            positions[c - 'a'].add(index)
        }

        var minLength = Int.MAX_VALUE
        var maxLength = Int.MIN_VALUE

        for (posList in positions) {
            if (posList.size >= k) {
                for (i in 0..posList.size - k) {
                    val currentLength = posList[i + k - 1] - posList[i] + 1
                    minLength = minOf(minLength, currentLength)
                    maxLength = maxOf(maxLength, currentLength)
                }
            }
        }

        if (minLength == Int.MAX_VALUE) {
            println("-1")
        } else {
            println("$minLength $maxLength")
        }
    }
}
