fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()
        val list = ArrayList<Pair<Int, Int>>()
        repeat(n) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            list.add(Pair(a, b))
        }
        list.sortBy { it.first }
        var count = 1
        var minB = list.first().second
        for ((a, b) in list.drop(1)) {
            // 자기보다 모두 뛰어난 사람이 없다면
            if (minB > b) {
                minB = b
                count++
            }
        }
        sb.append(count).append("\n")
    }
    print(sb.toString())
}