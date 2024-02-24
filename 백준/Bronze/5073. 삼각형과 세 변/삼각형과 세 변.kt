fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    while (true) {
        val nums = br.readLine().split(" ").map { it.toInt() }.sorted()

        if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) break

        if (nums[0] + nums[1] <= nums[2]) {
            sb.append("Invalid\n")
            continue
        }

        when (nums.toSet().size) {
            1 -> sb.append("Equilateral\n")
            2 -> sb.append("Isosceles\n")
            3 -> sb.append("Scalene\n")
        }
    }
    println(sb.toString())
}
