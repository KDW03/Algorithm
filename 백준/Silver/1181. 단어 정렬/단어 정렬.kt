fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = ArrayList<String>()

    repeat(n) {
        arr.add(br.readLine())
    }

    arr.sorted().sortedBy {
        it.length
    }.distinct().forEach { println(it) }

}
