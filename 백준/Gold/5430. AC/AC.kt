fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val t = br.readLine().toInt()
    outer@ for (i in 0 until t) {
        val p = br.readLine()
        val n = br.readLine().toInt()
        val list = br.readLine().drop(1).dropLast(1).split(",").toMutableList()
        if (n == 0 && p.contains('D')) {
            sb.append("error").append("\n")
            continue@outer
        }
        //R 뒤집기
        //D 버리기
        // flag가 true면 removefirst 아니면 removelast
        var flag = true

        for (cmd in p) {
            try {
                when (cmd) {
                    'R' -> flag = !flag
                    'D' -> if (flag) list.removeFirst() else list.removeLast()
                }
            } catch (e: NoSuchElementException) {
                sb.append("error").append("\n")
                continue@outer
            }
        }
        val tmp = if (flag) list.joinToString(",") else list.reversed().joinToString(",")
        sb.append("[$tmp]").append("\n")
    }
    println(sb.toString())
}