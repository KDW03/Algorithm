fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    print(if (n % 7 == 1 || n % 7 == 3) "CY" else "SK")
}