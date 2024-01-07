fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr: MutableList<Pair<Int, Int>> = mutableListOf()

    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(x, y))
    }

    arr.sortedWith(compareBy({ it.first }, { it.second })).forEach {
        println("${it.first} ${it.second}")
    }
}