fun main() {
    val br = System.`in`.bufferedReader()
    val list = br.readLine().split("-")

    var total = list[0].split("+").sumOf { it.toLong() }

    for (s in list.drop(1)) {
        total -= s.split("+").sumOf { it.toLong() }
    }

    println(total)
}