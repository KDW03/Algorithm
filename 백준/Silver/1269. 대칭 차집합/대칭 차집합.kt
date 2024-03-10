fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }

    val numCount = br.readLine().split(" ").map { it.toInt() }.groupingBy { it }.eachCount().toMutableMap()
    br.readLine().split(" ").map { it.toInt() }.forEach {
        numCount[it] = numCount.getOrDefault(it,0) + 1
    }

    println(numCount.filter { it.value == 1 }.keys.size)
}