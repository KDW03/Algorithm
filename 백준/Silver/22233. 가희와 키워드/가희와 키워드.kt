fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }

    val keyWords = mutableSetOf<String>()

    repeat(n) {
        val keyWord = br.readLine()
        keyWords.add(keyWord)
    }

    val sb = StringBuilder()

    repeat(m) {
        val useKeywords = br.readLine().split(",").toSet()
        keyWords -= useKeywords
        sb.append(keyWords.size).append("\n")
    }

    println(sb.toString())
}

