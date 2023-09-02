fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = mutableListOf<Char>()
    repeat(n) {
        arr.add(br.readLine().first())
    }

    arr.groupingBy { it }.eachCount().filter { it.value >= 5 }.toSortedMap().keys.joinToString("").let {
        println(it.ifEmpty { "PREDAJA" })
    }
}
