fun main() {
    val br = System.`in`.bufferedReader()
    val al = mutableListOf<String>()
    while (true) {
        val str = br.readLine() ?: break
        al.add(str)
    }

    val size = al.size.toDouble()
    val answer =
        al.groupingBy { it }.eachCount().toSortedMap().map { (k, v) -> "$k ${String.format("%.4f", (v / size) * 100)}" }

    answer.forEach {
        println(it)
    }
}
