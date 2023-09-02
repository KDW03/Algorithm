fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val regex = br.readLine().split("*")
    val first = regex[0]
    val end = regex[1]
    val sb = StringBuilder()
    for (i in 0 until n) {
        val str = br.readLine()

        if (str.length < first.length + end.length) {
            sb.append("NE").append("\n")
            continue
        }

        val fs = str.slice(first.indices)
        val ls = str.slice(str.length - end.length until str.length)
        if (fs == first && ls == end) {
            sb.append("DA")
        } else {
            sb.append("NE")
        }
        sb.append("\n")
    }
    println(sb.toString())
}