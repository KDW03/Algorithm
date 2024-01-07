import kotlin.math.round

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = ArrayList<Int>()
    repeat(n) {
        val num = br.readLine().toInt()
        arr.add(num)
    }
    arr.sort()

    println(round(arr.sum().toDouble() / arr.size).toInt())
    println(arr[arr.size / 2])
    // 최빈값 : N개의 수들 중 가장 많이 나타나는 값
    val gr = arr.groupingBy { it }.eachCount()
    val max = gr.maxBy { it.value }.value
    val ans = gr.filter { it.value == max }
    val s = if (ans.size == 1) {
        ans.keys.first()
    } else {
        ans.keys.sorted()[1]
    }
    println(s)
    // 범위 : N개의 수들 중 최댓값과 최솟값의 차이
    println(arr.last() - arr.first())

}