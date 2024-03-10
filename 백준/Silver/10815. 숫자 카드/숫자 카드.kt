fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val have = br.readLine().split(" ").map { it.toInt() }.groupingBy { it }.eachCount()


    val c = br.readLine().toInt()
    br.readLine().split(" ").map {
        val num = it.toInt()
        if (have[num] == null) 0 else 1
    }.joinToString(" ").let {
        println(it)
    }
}