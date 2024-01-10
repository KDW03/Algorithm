fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val s = br.readLine()

    var pn = ""
    for (i in 0 until n) {
        pn += "IO"
    }
    pn += "I"
    var count = 0
    for (i in s.indices) {
        if (s[i] == 'I') {
            val str = s.substring(i until minOf(i + pn.length, s.length))
            if (str == pn) count++
        }
    }

    println(count)
}