import kotlin.math.abs

// 왼쪽 또는 오른쪽 중 큰거 개수 및 그것의 인덱스
data class D(val count: Int = 0, val index: Int = -1)
data class Building(val LD: D, val RD: D, val idx: Int, val height: Int)

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val heights = br.readLine().split(" ").mapIndexed { i, v -> Pair(i, v.toInt()) }.sortedByDescending {
        it.second
    }

    val answers = arrayListOf<Building>()

    for (h in heights) {
        val insertIdx = -answers.binarySearch {
            it.idx.compareTo(h.first)
        } - 1

        var li = insertIdx - 1
        var ri = insertIdx

        while (li >= 0 && answers[li].height <= h.second) {
            li--
        }

        while (ri < answers.size && answers[ri].height <= h.second) {
            ri++
        }

        val ld = if (li >= 0) answers[li].let {
            D(it.LD.count + 1, it.idx)
        } else D()

        val rd = if (ri < answers.size) answers[ri].let {
            D(it.RD.count + 1, it.idx)
        } else D()

        answers.add(insertIdx, Building(ld, rd, h.first, h.second))
    }

    val sb = StringBuilder()
    answers.forEach {
        val ld = it.LD
        val rd = it.RD

        val tmp = arrayOf(ld, rd).filter { d -> d.count > 0 }.minByOrNull { fd ->
            abs(fd.index - it.idx)
        }

        if (tmp == null) {
            sb.append(0).append("\n")
        } else {
            sb.append("${ld.count + rd.count} ${tmp.index + 1}").append("\n")
        }

    }

    println(sb.toString().trimEnd())

}