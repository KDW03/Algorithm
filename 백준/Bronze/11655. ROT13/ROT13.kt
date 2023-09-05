fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine().map {
        when (it) {
            in 'a'..'z' -> {
                'a' + (it.code - 'a'.code + 13) % 26
            }

            in 'A'..'Z' -> {
                'A' + (it.code - 'A'.code + 13) % 26
            }

            else -> {
                it
            }
        }
    }.joinToString("").let { println(it) }
}
