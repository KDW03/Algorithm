fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        var nums = br.readLine().split(" ").map { it.toLong() }
        var ans = 0L
        while (nums.size > 1) {
            val max = nums.max()
            val maxIndex = nums.lastIndexOf(max)
            ans += maxIndex * max - nums.slice(0 until maxIndex).sum()
            nums = nums.drop(maxIndex + 1)
        }
        println(ans)
    }
}
