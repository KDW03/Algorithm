
fun main() {
    val br = System.`in`.bufferedReader()
    while (true) {
        val str = br.readLine()
        if (str == "end") break
        println("<${str}> is ${if (check(str)) "" else "not "}acceptable.")
    }
}

fun check(test: String): Boolean {
    val ma = arrayOf('a', 'e', 'i', 'o', 'u')
    val ca = arrayOf('e', 'o')
    var flag = false
    var mc = 0
    var jc = 0
    var pre: Char? = null
    test.forEach {
        if (!flag && it in ma) {
            flag = true
        }
        if (pre != null && pre == it && pre !in ca) return false
        pre = it
        if (it in ma) {
            mc++
            jc = 0
        } else {
            jc++
            mc = 0
        }
        if (mc >= 3 || jc >= 3) return false
    }
    return flag
}