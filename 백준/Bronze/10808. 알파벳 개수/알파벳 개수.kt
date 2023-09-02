fun main() {
    val br = System.`in`.bufferedReader()
    (br.readLine() + ('a'..'z').joinToString("")).groupingBy { it }.eachCount()
        .toSortedMap().values.map { it - 1 }.joinToString(" ").let {
        println(it)
    }
}
