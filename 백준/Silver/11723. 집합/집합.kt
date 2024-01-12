fun main() {
    val br = System.`in`.bufferedReader()
    var set = hashSetOf<Int>()
    val sb = StringBuilder()
    for (i in 0 until br.readLine().toInt()) {
        val c = br.readLine()
        if (c == "all") {
            set = hashSetOf<Int>().apply { addAll((1..20).toList()) }
            continue
        }
        if (c == "empty") {
            set = hashSetOf()
            continue
        }

        val tmp = c.split(" ")
        val cm = tmp[0]
        val num = tmp[1].toInt()

        when (cm) {
            "add" -> {
                set.add(num)
            }
            "check" -> {
                sb.append(if (set.contains(num)) 1 else 0).append("\n")
            }
            "remove" -> {
                set.remove(num)
            }
            "toggle" -> {
                if (set.contains(num)) set.remove(num) else set.add(num)
            }
        }
    }

    println(sb.toString())
}