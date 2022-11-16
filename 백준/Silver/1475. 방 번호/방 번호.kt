fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()
    val arr = IntArray(9)
    for (i in n) {
        val currentValue = Character.getNumericValue(i)
        if (currentValue == 9) arr[6]++
        else arr[currentValue]++
    }
    if (arr[6] % 2 == 1) arr[6] += 1
    arr[6] /= 2
    println(arr.maxOrNull())
}
