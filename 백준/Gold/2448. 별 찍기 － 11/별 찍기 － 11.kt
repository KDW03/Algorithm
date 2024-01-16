fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    starPattern(n).forEach { println(it) }
}

fun fillStars(arr: Array<CharArray>, x: Int, y: Int, size: Int) {

    if (size == 3) {
        arr[x][y] = '*'
        arr[x + 1][y - 1] = '*'
        arr[x + 1][y + 1] = '*'
        for (i in -2..2) arr[x + 2][y - i] = '*'
        return
    }

    val newSize = size / 2
    fillStars(arr, x, y, newSize)
    fillStars(arr, x + newSize, y - newSize, newSize)
    fillStars(arr, x + newSize, y + newSize, newSize)
}

fun starPattern(n: Int): Array<String> {
    val arr = Array(n) { CharArray(2 * n) { ' ' } }
    fillStars(arr, 0, n - 1, n)
    return arr.map { it.joinToString("") }.toTypedArray()
}