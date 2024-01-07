fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    while (true) {
        val nums = br.readLine().split(" ").map { it.toInt() }
        if (nums.sum() == 0) break

        val sort = nums.sorted()
        if (sort[0] * sort[0] + sort[1] * sort[1] == sort[2] * sort[2]) sb.append("right").append("\n")
        else sb.append("wrong").append("\n")
    }

    println(sb.toString())
}
