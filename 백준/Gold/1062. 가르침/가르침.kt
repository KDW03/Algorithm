val wordArr = mutableListOf<Int>()
var max = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val basic = setOf('a', 'n', 't', 'i', 'c')
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val remain = ('a'..'z').toSet() - basic

    repeat(n) {
        val str = br.readLine().toSet() - basic
        var bitmask = 0
        for (ch in str) {
            bitmask = bitmask or (1 shl (ch - 'a'))
        }
        wordArr.add(bitmask)
    }

    if (k < 5) {
        println(0)
        return
    }

    combination(remain.toList(), k - 5)

    println(max)
}

fun combination(remain: List<Char>, k: Int, now: Int = 0, idx: Int = 0) {
    if (k == 0) {
        val count = wordArr.count {
            (it and now) == it
        }
        max = maxOf(max, count)
        return
    }

    if (idx == remain.size) return

    combination(remain, k, now, idx + 1)
    combination(remain, k - 1, now or (1 shl (remain[idx] - 'a')), idx + 1)
}
