fun main() {
val sb= StringBuilder()
    val dn = BooleanArray(10001)
    for (i in 1 until dn.size) {
        if (!dn[i]) {
            sb.append(i).append("\n")
        }
        val n = i + i.toString().sumOf {
            it.digitToInt()
        }
        if (n in dn.indices) {
            dn[n] = true
        }
    }
    println(sb.toString())
}

