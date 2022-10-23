var height: Int = 0
lateinit var dp: IntArray
fun main() {
    val br = System.`in`.bufferedReader()
    height = br.readLine().toInt()
    val arr = ArrayList<Int>((height * (height + 1)) / 2)
    dp = IntArray((height * (height + 1)) / 2) { -1 }
    for (i in 0 until height)
        arr.addAll(br.readLine().split(' ').map { it.toInt() })
    println(findMax(arr, 0, 1))
}

fun findMax(arr: ArrayList<Int>, idx: Int, nowHeight: Int): Int {
    if (height < nowHeight) return 0
    if (dp[idx] == -1) { //저장된 값이 없다면 저장해주고 반환
        dp[idx] = maxOf(
            findMax(arr, idx + nowHeight, nowHeight + 1),
            findMax(arr, idx + nowHeight + 1, nowHeight + 1)
        ) + arr[idx]
    }
    return dp[idx]
}