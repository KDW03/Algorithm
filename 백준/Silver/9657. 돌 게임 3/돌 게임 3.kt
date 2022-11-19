fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    print(if (n % 7 == 0 || n % 7 == 2) "CY" else "SK")
}