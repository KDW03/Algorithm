import kotlin.math.*

class Solution {
    fun solution(n: Int, k: Int): Int {

        val t = n.toString(k).replace(Regex("0{2,}"), "0").split("0").filter { it.isNotEmpty() }
        return if (t.isEmpty()){
            0
        }else {
            t.map { it.toLong()}.count{ isSosoo(it)}
        }
    }
}


fun isSosoo(x: Long): Boolean {
    if (x < 2) return false
    for (i in 2..sqrt(x.toDouble()).toInt()) {
        if (x % i.toLong() == 0L) return false
    }
    return true
}

