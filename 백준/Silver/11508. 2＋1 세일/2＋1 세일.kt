fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = IntArray(n)

    repeat(n) {
        arr[it] = br.readLine().toInt()
    }

    var count = 1
    var totalPrice = 0

    for (p in arr.sortedDescending()) {
        if (count != 3) {
            totalPrice += p
            count++
        } else {
            count = 1
        }
    }

    println(totalPrice)
}
