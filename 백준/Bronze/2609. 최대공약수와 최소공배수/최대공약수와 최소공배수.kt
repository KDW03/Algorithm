fun main() {
    val br = System.`in`.bufferedReader()
    val (a,b) = br.readLine().split(" ").map { it.toInt() }
    val gcd = gcd(a,b)
    println(gcd)
    println(a*b / gcd)
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b , a % b)
}