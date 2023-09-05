var max = Long.MIN_VALUE
var min = Long.MAX_VALUE
var s = listOf<String>()

fun main() {
    val br = System.`in`.bufferedReader()
    val k = br.readLine().toInt()
    s = br.readLine().split(" ")
    combination(k)
    println(String.format("%0${k + 1}d", max))
    println(String.format("%0${k + 1}d", min))
}

fun checkRight(list: List<Int>, s: List<String>): Boolean {
    var pre = list[0]
    for (i in s.indices) {
        val now = list[i + 1]
        when (s[i]) {
            ">" -> {
                if (pre < now) return false
            }
            "<" -> {
                if (pre > now) return false
            }
        }
        pre = now
    }
    return true
}

fun combination(k: Int, now: MutableList<Int> = mutableListOf()) {

    if (now.size > 1 && !checkRight(now.subList(now.size - 2, now.size), s.subList(now.size - 2, now.size - 1))) {
        return
    }

    if (now.size == k + 1) {
        val num = now.joinToString("").toLong()
        if (checkRight(now, s)) {
            max = maxOf(max, num)
            min = minOf(min, num)
        }
        return
    }

    for (i in 0..9) {
        if (!now.contains(i)) {
            combination(k, now.apply { add(i) })
            now.remove(i)
        }
    }
}
