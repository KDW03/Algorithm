fun main() {
    val br = System.`in`.bufferedReader()
    val (H, W) = br.readLine().split(" ").map { it.toInt() }
    val blocks = br.readLine().split(" ").map { it.toInt() }

    var totalWater = 0

    for (i in 0 until W) {
        val leftMax = blocks.subList(0, i).maxOrNull() ?: 0
        val rightMax = blocks.subList(i + 1, W).maxOrNull() ?: 0
        val minSideHeight = minOf(leftMax, rightMax)

        if (minSideHeight > blocks[i]) {
            totalWater += minSideHeight - blocks[i]
        }
    }

    println(totalWater)
}