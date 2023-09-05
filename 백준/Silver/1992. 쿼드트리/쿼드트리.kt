fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    val arr = Array(n) { br.readLine().map { it.digitToInt() }.toIntArray() }

    val sb = StringBuilder()

    dfs(arr, n, sb)

    println(sb.toString())

}

fun dfs(arr: Array<IntArray>, n: Int, sb: java.lang.StringBuilder) {

    if (n == 1) {
        sb.append(arr[0][0])
        return
    }

    val sum = arr.sumOf {
        it.sumOf { v -> v }
    }

    when (sum) {
        n * n -> {
            sb.append(1)
        }
        0 -> {
            sb.append(0)
        }
        else -> {
            val topOrLeftRange = 0 until n / 2
            val bottomOrRightRange = n / 2 until n

            val tl = arr.sliceArray(topOrLeftRange).map {
                it.sliceArray(topOrLeftRange)
            }.toTypedArray()

            val tr = arr.sliceArray(topOrLeftRange).map {
                it.sliceArray(bottomOrRightRange)
            }.toTypedArray()


            val bl = arr.sliceArray(bottomOrRightRange).map {
                it.sliceArray(topOrLeftRange)
            }.toTypedArray()

            val br = arr.sliceArray(bottomOrRightRange).map {
                it.sliceArray(bottomOrRightRange)
            }.toTypedArray()

            val list = arrayOf(tl, tr, bl, br)

            sb.append("(")
            for (i in 0 until 4) dfs(list[i], n / 2, sb)
            sb.append(")")
        }
    }
}