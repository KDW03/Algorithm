fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong() % 5L
    print(if (n == 0L || n == 2L) "CY" else "SK")
}