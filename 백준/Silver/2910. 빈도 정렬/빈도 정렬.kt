fun main() {
    val br = System.`in`.bufferedReader()
    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.groupingBy { it }.eachCount().entries.sortedByDescending {
        it.value
    }
    val sb = StringBuilder()
    arr.forEach { map ->
        repeat(map.value) {
            sb.append("${map.key} ")
        }
    }
    println(sb.toString().trim())
}
