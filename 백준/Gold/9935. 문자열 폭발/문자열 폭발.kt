fun main() {
    val br = System.`in`.bufferedReader()
    val baseString = br.readLine()
    val pattern = br.readLine()

    val sb = StringBuilder()
    for (c in baseString) {
        sb.append(c)
        if (sb.endsWith(pattern)) {
            sb.delete(sb.length - pattern.length, sb.length)
        }
    }

    println(sb.toString().ifBlank { "FRULA" })
}