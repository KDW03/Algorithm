fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    val sb = StringBuilder()

    fun makeCombi(combiArr: IntArray, i: Int) {
        if (combiArr.size == m) {
            sb.append(combiArr.joinToString(" ")).append("\n")
            return
        }

        for (k in i until nums.size) makeCombi(combiArr + nums[k], k)
    }

    makeCombi(intArrayOf(), 0)

    println(sb.toString())
}
