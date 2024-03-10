fun main() {
    val br = System.`in`.bufferedReader()
    val x = br.readLine().toInt()
    var n = 0
    var count = 0

    while(count < x) {
        n++
        count += n
    }

    val step = count - x
    if (n % 2 == 0) {
        println("${n - step}/${1 + step}")
    } else {
        println("${1 + step}/${n - step}")
    }
}