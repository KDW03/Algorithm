fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    print(if(n%7L == 0L|| n%7L==2L) "CY" else "SK")
}