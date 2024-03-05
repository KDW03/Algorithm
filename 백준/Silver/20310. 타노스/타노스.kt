fun main() {
    val br = System.`in`.bufferedReader()

    val str = br.readLine()

    val counts = str.groupingBy { it }.eachCount()
    var zeroCount = counts.getOrDefault('0',0) / 2
    var rOneCount = counts.getOrDefault('1',0) / 2

    val sb = StringBuilder()

    str.forEach {
        if (it == '0') {
            if (zeroCount > 0) {
                zeroCount--
                sb.append('0')
            }
        } else {
            if (rOneCount > 0) {
                rOneCount--
            }else {
                sb.append('1')
            }
        }
    }
    println(sb.toString())
}
