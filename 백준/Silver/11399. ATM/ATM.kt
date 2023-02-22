fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var sum = 0
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()
    var wait = 0
    for (i in list) {
        sum += (i + wait)
        wait += i
    }
    println(sum)
}