class Solution {
    fun solution(numbers: LongArray): LongArray = numbers.map { num ->
        val binaryString = "0" + num.toString(2)
        val zeroFirst = binaryString.indexOfLast { it == '0' }
        val t =
            if (zeroFirst == binaryString.length - 1) binaryString.dropLast(1) + "1" else binaryString.substring(0 until zeroFirst) + "10" + binaryString.substring(
                zeroFirst + 2
            )
        t.toLong(2)
    }.toLongArray()
}