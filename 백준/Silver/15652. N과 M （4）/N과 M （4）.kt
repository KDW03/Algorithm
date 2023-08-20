import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val set: MutableSet<String> = mutableSetOf()
    for (i in 1 ..n) {
        combination((1..n).toList(), m, set, arrayOf(i))
    }
    val sb = StringBuilder()

    for (s in set) {
        sb.append(s).append("\n")
    }

    println(sb.toString())
}

fun combination(list: List<Int>, m: Int, set: MutableSet<String>, newArr: Array<Int> = arrayOf()) {
    if (newArr.size == m) {
        set.add(newArr.joinToString(" "))
        return
    }

    // 가장 최근에 뽑은것 부터
    for (idx in newArr.last() - 1 until list.size) combination(list, m, set, newArr + list[idx])
}