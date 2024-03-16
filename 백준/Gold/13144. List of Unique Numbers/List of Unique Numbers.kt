
fun countUniqueSubsequences(arr: List<Int>): Long {
    var count: Long = 0
    var start = 0
    var end = 0
    val seen = mutableSetOf<Int>()

    while (end < arr.size) {
        if (arr[end] !in seen) {
            seen.add(arr[end])
            count += (end - start + 1)
            end += 1
        } else {
            seen.remove(arr[start])
            start += 1
        }
    }

    return count
}


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    println(countUniqueSubsequences(arr))
}