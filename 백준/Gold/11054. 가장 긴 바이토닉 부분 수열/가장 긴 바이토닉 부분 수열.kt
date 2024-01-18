fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val dpLeftStart = IntArray(n) { 1 }
    val dpRightStart = IntArray(n) { 1 }
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) dpLeftStart[i] = maxOf(dpLeftStart[i], dpLeftStart[j] + 1)
        }
    }

    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo i + 1) {
            if (nums[i] > nums[j]) dpRightStart[i] = maxOf(dpRightStart[i], dpRightStart[j] + 1)
        }
    }
    var max = Int.MIN_VALUE
    for (i in 0 until n) {
        max = maxOf(dpLeftStart[i] + dpRightStart[i], max)
    }

    println(max - 1)
}