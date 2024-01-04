fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = IntArray(n)

    repeat(n) {
        arr[it] = br.readLine().toInt()
    }

    arr.sortDescending()
    var answer = arr[0]

    for ((i,v) in arr.withIndex()) {
        val new = v  * (i + 1)
        if (new >= answer) {
            answer = new
        }
    }
    println(answer)
}