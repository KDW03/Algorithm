data class Num(val idx: Int, val value: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").mapIndexed { index, value -> Num(index, value.toInt()) }.sortedBy { it.value }
    val ansSet = LinkedHashSet<String>()

    fun makeCombi(arr: List<Num> = arrayListOf()) {
        if (arr.size == m) {
            ansSet.add(arr.map { it.value }.joinToString(" "))
            return
        }
        val possibleArr = nums - arr
        for (i in possibleArr.indices) makeCombi(arr + possibleArr[i])
    }
    for (i in nums.indices) makeCombi(listOf(nums[i]))
    val sb = StringBuilder()
    ansSet.forEach {
        sb.append(it).append("\n")
    }
    print(sb.toString().trimEnd())
}