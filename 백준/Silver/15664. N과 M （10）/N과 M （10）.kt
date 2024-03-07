fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    val sb = StringBuilder()
    var last = IntArray(m)

    fun bigger(a: IntArray, b: IntArray): Boolean {
        for (i in 0 until m) {
            if (a[i] > b[i]) return true
        }
        return false
    }

    fun combi(k: Int = 0, now: IntArray = intArrayOf()) {

        if (now.size == m) {
            if (bigger(now, last)) {
                sb.append(now.joinToString(" ")).append("\n")
                last = now
            }
            return
        }

        for (i in k until n) combi(i + 1, now + nums[i])
    }
    combi()
    print(sb.toString())
}
