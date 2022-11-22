fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    print(if(n % 2L == 1L)  "SK" else "CY")
}