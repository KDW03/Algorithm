fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    print(if(n % 2 > 0)  "SK" else "CY")
}