fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    sb.append((1 shl n) - 1).append("\n")

    fun hanoi(n: Int, start: Int, to: Int, via: Int) {
        if (n == 1) {
            sb.append("$start $to").append("\n")
            return
        }
        hanoi(n - 1, start, via, to)
        sb.append("$start $to").append("\n")
        hanoi(n - 1, via, to, start)
    }
    hanoi(n, 1, 3, 2)
    print(sb.toString())
}