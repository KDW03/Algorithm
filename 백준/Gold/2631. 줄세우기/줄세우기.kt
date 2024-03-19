fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = Array(n) { br.readLine().toInt() }

    val lisCandidates = ArrayList<Int>()

    for (num in nums) {
        val pos = lisCandidates.binarySearch(num)
        if (pos < 0) {
            val insertPos = -(pos + 1)
            if (insertPos == lisCandidates.size) {
                lisCandidates.add(num)
            } else {
                lisCandidates[insertPos] = num
            }
        }
    }

    println(n - lisCandidates.size)
}