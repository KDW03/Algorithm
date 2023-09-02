fun main() {
    val br = System.`in`.bufferedReader()
    val heightArr = IntArray(9) { br.readLine().toInt() }
    val sum = heightArr.sum()

    for (i in 0 until 9) {
        for (j in i + 1 until 9) {
            if (sum - heightArr[i] - heightArr[j] == 100) {
                val result = heightArr.filterIndexed { index, _ -> index != i && index != j }.sorted()
                for (height in result) {
                    println(height)
                }
                return
            }
        }
    }
}